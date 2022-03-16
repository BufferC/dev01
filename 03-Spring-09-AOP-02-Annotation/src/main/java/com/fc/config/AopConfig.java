package com.fc.config;

import com.fc.advice.AnnotationAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.fc")
@Configuration
public class AopConfig {
    @Bean
    public AnnotationAdvice annotationAdvice() {
        return new AnnotationAdvice();
    }
}
