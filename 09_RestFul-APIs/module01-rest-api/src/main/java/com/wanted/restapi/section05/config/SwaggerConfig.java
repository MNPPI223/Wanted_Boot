package com.wanted.restapi.section05.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().
                components(new Components())
                .info(apiInfo());
    }
    private Info apiInfo() {
        return new Info()
                .title("REST API 수업 API 명세서")
                .description("REST API Swagger 적용 명세서입니다...")
                // 대규모 : 첫번째, 정기 : 중간, 소규모 : 마지막
                .version("2.0.0");
    }
}
