from fastapi import APIRouter
from schemas.chat_schema import ChatRequest, ChatResponse

# @RequestMapping("/api/v1/chat")
# class ~~

# @GetMapping("/{id}") "/api/v1/chat/{id}"
router = APIRouter(

    prefix = "/api/v1/chat", 
    tags = ["chat-API"]

)
# /api/v1/chat POST 요청을 처리하는 함수
@router.post("",response_model=ChatResponse)
def chat(request: ChatRequest):
    return ChatResponse(
        question = request.question,
        answer = f"{request.question} 에 대한 답변",
        model = "Claude Fable 5",
        used_token = 5235423 
    )