package com.wanted.restapi.section03.valid;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorResponse {

    // Error 발생 시 공통으로 사용할 템플릿 클래스

    private String code;
    private String description;
    private String detail;

}
