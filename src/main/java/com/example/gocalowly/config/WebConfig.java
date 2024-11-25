package com.example.gocalowly.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.gocalowly.domain.token.interceptor.JweAuthenticationInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	private final JweAuthenticationInterceptor jweAuthenticationInterceptor;
	
	public WebConfig(JweAuthenticationInterceptor jweAuthenticationInterceptor) {
		this.jweAuthenticationInterceptor = jweAuthenticationInterceptor;
	}
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        	.allowedOrigins("http://localhost:8080", "http://localhost:5173") // 허용할 출처
            .allowedMethods("GET", "POST") // 허용할 HTTP method
            .allowCredentials(true) // 쿠키 인증 요청 허용
            .maxAge(3000); // 원하는 시간만큼 pre-flight 리퀘스트를 캐싱
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(jweAuthenticationInterceptor)
    	.addPathPatterns("/api/**")
    	.excludePathPatterns("/api/user/login")
    	.excludePathPatterns("/api/user/signup");
    }
    
    
}
