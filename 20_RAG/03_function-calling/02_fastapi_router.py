"""
/chat 앤드포인트를 FastAPI 서버에서 만들어둔다.
Spring 백엔드 서버에서는 사용자 요청 시 /chat 엔드포인트를 호출한다.
또한 FastAPI 서버는 필요하다면 Spring 백엔드의 엔드포인트를 역호출 한다.
"""
import os
from contextlib import asynccontextmanager

import chromadb
import httpx
from chromadb.utils import embedding_functions
from dotenv import load_dotenv
from fastapi import FastAPI
from google import genai
from google.genai import types
from pydantic import BaseModel, Field

load_dotenv()

MODEL_NAME = "jhgan/ko-sroberta-multitask"
CHROMA_PATH = "./chroma_db"
GEMINI_MODEL = "gemini-3.5-flash"
SPRING_BASE_URL = os.getenv("SPRING_BASE_URL")
# 타임아웃은 정해져있지는 않음. (다만 이탈률이 있는데, 이거를 데이터로 판단을 한다.)
TIMEOUT = httpx.Timeout(5.0)
SIMILARITY_THRESHOLD = 0.35

resources: dict = {}

@asynccontextmanager
async def lifespan(app: FastAPI):
    print("초기화 중...")
    chroma = chromadb.PersistentClient(path=CHROMA_PATH)
    ef = embedding_functions.SentenceTransformerEmbeddingFunction(model_name=MODEL_NAME)
    resources["docs"] = chroma.get_or_create_collection(
        "lms_regulation", embedding_function=ef, metadata={"hnsw:space": "cosine"})
    resources["courses"] = chroma.get_or_create_collection(
        "lms_courses", embedding_function=ef, metadata={"hnsw:space": "cosine"})
    resources["genai"] = genai.Client(api_key=os.getenv("GOOGLE_API_KEY"))
    print("초기화 완료")
    # 이 부분은 서버가 켜짐과 동시에 설정해야하는 것들
    # Spring 으로 치자면 yml 파일이 동작하는 것이라고 보면 된다.
    yield
    # 이 부분은 서버가 꺼질 때 동작하는 것들
    # ex) 리소스 정리 / close() 는 서브를 말하는거고, 여기서는 전체 정리
    resources.clear()

app = FastAPI(
    title="LMS AI Server",
    description="RAG + function Calling 통합 챗봇",
    lifespan=lifespan
)

# ==========================================================================
# 요청/응답 스키마
class ChatMessage(BaseModel):
    role: str = Field(..., pattern="^(user|assistant)$") # ... 의 뜻은 notNull 을 의미한다.
    content: str


class ChatRequest(BaseModel):
    question: str = Field(..., min_length=1)
    student_id: int = Field(1, description="로그인한 학생 ID (Spring이 전달)")
    history: list[ChatMessage] = Field(default_factory=list)


class ChatResponse(BaseModel):
    answer: str
    used_tools: list[str]   # 모델이 어떤 도구를 썼는지 (디버깅/신뢰성용)
# ==========================================================================
