package com.wanted.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* comment.
    WebMvcConfigurer 인터페이스는
    Spring MVC 패턴의 기본설정을 유지하며, 추가적인 커스터마이징이
    필요할 때 구현하는 인터페이스다.
    ex) 인터셉터 추가, CORS 설정, 정적 리소스 핸들링 등
 */

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final StopWatchInterceptor stopWatchInterceptor;

    @Autowired
    public WebConfiguration(StopWatchInterceptor stopWatchInterceptor) {
        this.stopWatchInterceptor = stopWatchInterceptor;
    }

    /* comment.
        addPathPatterns(..)
        - 지정한 범위에서 인터셉터를 동작하게 만드는 메서드
        - "/*" 의미는 모든 경로에 인터셉터를 동작하게 만들겠다는 의미.
        - "/**" : 모든 하위 경로까지 포함하는 포괄적인 패턴
        excludePathPatterns(..)
        - addPathPatterns 으로 지정한 범위 중, 인터셉터 동작을
        - 적용하지 않고자 하는 URL 패턴을 지정하는 메서드
        - 정적 리소스(css, js, image) 등 불필요한 호출과 부하를
        - 막기 위해 "반드시" 제외해야 한다.
     */
    // 메인페이지를 새로고침해도 preHandle 과 postHandler 는 호출된다. <중요!!!>

    @Override
    // registry 는 저장소라고 생각하면 된다.
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(stopWatchInterceptor)
                .addPathPatterns("/*")
                // * : 파일 하나 / 정적인 파일은 전부 제외하겠다. 비효율적이니까 <주의!!!>
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/error/**");
    }
}
