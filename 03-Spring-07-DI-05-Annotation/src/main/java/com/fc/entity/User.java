package com.fc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@AllArgsConstructor
@Component
@Scope("singleton")
public class User {
    @Value("1")
    private Integer id;
    @Value("易烊千玺")
    private String username;
    @Value("123456")
    private String password;

    public User() {
        System.out.println("构造方法被执行");
    }

    // 声明此注解，会在构造方法执行后执行
    @PostConstruct
    public void eat() {
        System.out.println("老弟套餐");
    }

    // 之前销毁
    @PreDestroy
    public void sleep() {
        System.out.println("吃了睡");
    }
}
