package com.fc.controller;

import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class HelloController {
    @RequestMapping("/")
    public String goHome() {
        System.out.println("执行此方法");
        return "hello.html";
    }
}
