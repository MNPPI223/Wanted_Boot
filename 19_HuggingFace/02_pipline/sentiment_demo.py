# torch 는 딥러닝 모델의 학습 및 추론을 지원하는 라이브러리이다.
# CPu / GPU 를 추론 시 활용할 용도로 사용
import torch
from transformers import pipeline
from typing import Any

# 해당 모델은 HuggingFace 에 있는 영어 문장 긍정/부정 분류 AI 모델이다.
MODEL_ID = "distilbert/distilbert-base-uncased-finetuned-sst-2-english"

def create_sentiment_analyzer() -> Any:

    # GPU / CPU
    # torch.cuda.is_available() GPU 사용 가능 여부를 확인해서,
    # 0 은 첫번째 GPU, -1 은 GPU 가 아닌 CPU 를 활용함
    device = 0 if torch.cuda.is_available() else -1

    # pipeline() 은 토큰화 -> 모델 추론 -> 결과 변환 과정을 한 번에 처리한다.
    # 최초 실행 시 모델과 토크나이저를 내려 받게 된다.
    return pipeline(
            # 수행 할 작업을 지정한다. HuggingFace 의 Tasks
            task="sentiment-analysis",
            # 위에 선언한 모델을 지정한다.
            model = MODEL_ID,
            # 모델을 실행할 CPU or GPU 를 지정한다.
            device=device
    )

# 문장과 감정 분석 결과를 보기 좋게 출력하는 함수
# sentence 사용자 입력 문장 / prediction : 입력 문장에 대한 AI 응답 값
def print_prediction(sentence : str, prediction : dict[str, Any]) -> None :
    # 감정 분석 모델 응답 결과 양식 -> {"label" : "POSITIVE", "score" : 0.9998}
    label = str(prediction["label"])
    score = float(prediction["score"])

    print(f"사용자 입력 문장 : {sentence}")
    print(f"사용자의 현재 감정 : {label}")
    # .4f 실수를 소수점 아래 4자리까지만 출력하는 형식
    print(f"감정 정확도 점수 : {score:.4f} ")
    print("-" * 30)

# 단일 문장 감정 분석 함수
def analyze_single_sentence(analyzer : Any) -> None :

    sentence = "I make this shit. brick by brick. This is my Ego"

    # 문장이 하나여도 pipeline 은 결과를 List 로 반환하기 때문에
    prediction = analyzer(sentence)[0]

    print("\n [단일 문장 감정 분석 동작중...]")
    print_prediction(sentence, prediction)

# 복수 문장 감정 분석 함수
def analyze_mulitple_sentences(analyzer : Any) -> None : # 이 타입은 void 타입이라고 보면 된다.
    sentences = [
        "I just want to go home",
        "Recharge after power bank cools down",
        "God focus dicsipline dreams on",
        "just do it"
    ]

    predictions = analyzer(sentences)

    print("\n[여러 문장 분석...]")

    # zip() 은 사용자 입력 문장과 에측 결과를 1개의 쌍으로 묶는다.
    # 1회 반복 시 1번 입력 문장 <-> 1번 결과를 이렇게 묶이게 된다
    for sentence, prediction in zip(sentences, predictions):
        print_prediction(sentence, prediction)


def main() -> None :
    print("HuggingFace 감정 분석 실습")
    print(f"사용하는 Mdoel : {MODEL_ID}")

    try :
        # create_sentiment_analyzer() 함수는 Pipline 을 Return 한다.
        analyzer = create_sentiment_analyzer()

        # 단일 문장 감정 분석 실습함수 호출
        # 위 pipeline 을 전달한다.
        # (잠깐 주석)analyze_single_sentence(analyzer)
        analyze_mulitple_sentences(analyzer)

    except Exception as e:
        print("\n 모델 실행 중 오류 발생!!!!")
        print(f"오류 내용입니다... : {e}")


if __name__ == "__main__":
    main()