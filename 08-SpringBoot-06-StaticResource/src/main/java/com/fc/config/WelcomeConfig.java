package com.fc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 欢迎页配置
@Configuration
public class WelcomeConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 设置映射的路径，只要访问根路径就会跳转到hello.html中
        registry.addViewController("/").setViewName("forward:/hello.html");

        // 设置优先级Spring中容器的优先级是根据Order进行排列的，数字越小优先级越高
        // 优先级可以使用负数
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
