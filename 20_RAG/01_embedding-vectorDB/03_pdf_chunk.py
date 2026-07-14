# 긴 문서는 단순 임베딩이 아닌 청크로 문장을 끊는 것이 핵심이다.
"""
[목표]
1. LMS 규정이 담긴 사내 문서 PDF 에서 Text 를 추출한다.
2. 긴 문서를 'Chunk' 로 자르는 이유와 방법에 대해 이해한다.
3. Chunk 로 잘린 Text 를 임베딩 후 VectorDB 에 저장하고 검색한다.

- 많은 양의 Text 를 통채로 임베딩을 하게 되면
- 1개의 벡터에 여러 주제가 섞여 유사도를 판단하기 좋지 않은 백터값이 된다.
- 따라서 Text 를 주제 / 핵심 키워드 등을 기준으로 잘라(청킹) 각각 임베딩을
- 해야 퀄리티 있는 답변을 만들어 낼 수 있게 된다.
"""

from pathlib import Path
# 문서가 들어오면 지정한 모델로 임베딩 해라 라는 것을 명령한다.
from chroma_db.utils import embedding_functions

# pdf 읽는 라이브러리
from pypdf import PdfReader

# Step 1. 사용 모델, DB 경로, 테이블 명, 청크 사이즈, 청크 오버랩
MODEL_NAME = "jhgan/ko-sroberta-multitask" # 한글 문장 임베딩 모델
CHROMA_PATH = "./chroma_db"                # 벡터가 저장될 로컬 폴더
COURSE_COLLECTION = "lms_regulation"          # RDB의 '테이블'에 해당하는 개념

CHUNK_SIZE = 500 # 1개의 청크에 포함되는 최대 글자 수
CHUNK_OVERLAP = 50 # 이웃 청크끼리 겹치는 글자 수

# STEP 2. PDF -> (1~9)페이지별 텍스트 추출
def extract_pages(pdf_path: str) -> list[dict]:
    """PDF의 각 페이지 텍스트를 추출한다.

    페이지 번호를 함께 보관하는 이유:
      나중에 챗봇이 답변할 때 "학사규정 4페이지 참고"처럼
      '출처'를 보여주기 위해서다. (RAG 신뢰성의 핵심!)
    """
    # PdfReader는 PDF 파일을 열고 .pages를 통해 페이지 단위로 접근하게 해준다.
    # 이미지로 스캔한 PDF에는 글자 데이터가 없어 extract_text()만으로 읽을 수 없다.
    reader = PdfReader(pdf_path)
    pages = []
    # enumerate(..., start=1)는 항목과 순번을 함께 주며, 실제 페이지처럼 1부터 센다.
    for page_num, page in enumerate(reader.pages, start=1):
        text = page.extract_text() or ""    # 빈 페이지면 None 대신 빈 문자열
        text = text.strip()
        if text:                             # 표지처럼 내용 없는 페이지는 제외
            pages.append({"page": page_num, "text": text})
    print(f"PDF 추출 완료: 총 {len(reader.pages)}페이지 중 {len(pages)}페이지에 텍스트 존재")
    return pages