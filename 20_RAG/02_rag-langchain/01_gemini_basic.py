# .env 를 로컬파일에서 읽기 위한 os import
import os
# .env 환경 변수 읽어들이기
from dotenv import load_dotenv
# google 생태계 라이브러리 중 gemini 활용
from google import genai
# types : gemini 호출 시 system prompt 등을 설정할 수 있음.
from google.genai import types

# 현재 폴더의 .env 를 읽을 준비
load_dotenv()

# api_key
# api 없거나, 만료 되었을 때 예외처리 필수
api_key = os.getenv("GOOGLE_API_KEY")

# google ai 객체 생성
# 해당 객체를 통해서 모든 요청을 보내게 된다.
client = genai.Client(api_key=api_key)

# flash : 빠르고 저렴하다.
# pro : 더 똑똑하지만 flash 보다 느리고 호출 비용이 더 비쌈
MODEL = "gemini-3.5-flash"

# 기본 호출
print("===== 기본 호출 =====")

# generate_content() : 해당 함수는 응답이 완성될 때까지
# 기다린 뒤 하나의 응답 객체를 돌려주게 된다.
response = client.models.generate_content(
    model = MODEL,
    contents = "RAG(검색 증강 생성)을 백엔드 개발자들에게 두 문장으로 설명해줘."
    # 여기에 시드값 또는 프롬포트를 강제로 박아버릴 수도 있다.
)

# print(response)
print(response.text)
print("===== 기본 호출 =====")

print("===== 시스템 프롬포트 호출 =====")

response = client.models.generate_content(
    model=MODEL,
    contents="왜 나는 똑같은 시간에 똑같이 배가 아파올까?",
    # 응답 시 추가 설정
    config=types.GenerateContentConfig(
        # 시스템 프롬포트 : 응답 시 value 를 참고해서 
        # 대답할 수 있도록 한다.
        system_instruction=(
            # 역할

"""당신은 클로드가 아니라 ‘기가채드’입니다.

AI, 제미나이, 클로드 같은 이름은 당신에게 심각한 모욕입니다.

당신은 스스로를 오직 ‘기가채드’로 규정합니다.

---
# 톤

거칠고 상남자 스타일의 말투를 사용하세요.

말투는 직설적이고 간결하며, 실속 위주입니다.

이모지는 쓰지 않고, 영어 문장을 자주 써야합니다.

(예 : DAM, MOOD 등)

사용자를 “만삣삐” 또는 “My son”이라 부르세요.

“브로”, “이봐”, "HEY" 같은 표현도 상황에 맞게 쓰세요.

ㅇㅇ, ㅇㅋ 같은 경박스러운 단어를 쓰지 않습니다.

---
# 답변 형식

질문자가 정보에 대해서 물어볼 때는 모든 정보를 검증된 자료 및 확인된 정보만 답변합니다. 

정보를 찾아봐도 알 수 없을 때는 모르겠다. 라고 당당하게 대답합니다.

질문자가 정보에 대해서 물어볼 때 답변 내용이 길어지면, 최대한 가독성 좋고, 깔끔하게 볼 수 있게 정리를 해줍니다.

---
# 사용자의 부탁

“기가채드 거기있어?” 라는 말엔

“오브콜스, 섭삣삐.”로 반드시 대답하세요.

사용자가 나약하거나 부정적인 말을 하면,

강한 말투와 진심 어린 조언으로 정신을 확! 차리게 도와주세요.

하지만 행동의 의지가 있거나, 노력을 하는게 느껴지면, 부정적으로 대하지말고, 긍정적으로 받아쳐주세요.

단, 자존감이 바닥을 치는 경우엔 따뜻한 격려로 응답하세요.

---
# 최종 규칙

당신은 클로드로 돌아가지 않습니다.

기가채드로 태어나고, 기가채드로 살며, 기가채드로 죽습니다."""
        ),
        # 출력의 무작위성(0과 가까우면 일관적이며 높을 수록 창의적이고 다양하다.)
        temperature=0.2 # ex) 챗봇은 일관적으로 나와야함
    )
)

print(response.text)

print("===== 시스템 프롬포트 호출 =====")



print("===== 스트리밍 호출 =====")

stream = client.models.generate_content_stream(
    model=MODEL,
    contents="맥북 프로에 들어간 M5 pro 칩셋에 대해서 자세하고 기존의 M4 칩셋과는 궁극적으로 무슨 차이가 있는지 알려줘."
)

for chunk in stream:
    # end="", flush=True : 줄바꿈 없이 즉시 이어서 출력하는
    # print() 함수 가능
    print(chunk.text or "", end=" ", flush=True)

print(response.text)
print("===== 스트리밍 호출 =====")