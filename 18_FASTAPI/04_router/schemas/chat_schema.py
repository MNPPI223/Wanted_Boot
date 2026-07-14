from fastapi import FastAPI
from pydantic import BaseModel , Field

app = FastAPI()

# 해당 파일은 Chat 과녈ㄴ Req, Res 객체를 작성하는 곳

class ChatRequest(BaseModel):
    question : str = Field(min_length=1, description="사용자 질문")

class ChatResponse(BaseModel):
    question : str
    answer : str
    model : str
    used_token : int

@app.post("/chat" , response_model=ChatResponse)
def chatbot(reqeust : ChatRequest) :

    return ChatResponse(
        question=reqeust.question,
        answer=f"{reqeust.question} 에 대한 답변!!!",
        model="gemini-flash",
        used_token=100000
    )