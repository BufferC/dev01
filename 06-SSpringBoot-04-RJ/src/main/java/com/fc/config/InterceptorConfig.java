package com.fc.config;

import com.fc.interceptor.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludePaths = {"/login.jsp","/user/login","/statics/**","/static/**"};
        registry.addInterceptor(new Interceptor())
                .order(-1)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePaths);
    }
}
