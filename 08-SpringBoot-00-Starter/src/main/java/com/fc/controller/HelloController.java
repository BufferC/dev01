package com.fc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class HelloController {
    @RequestMapping("hello")
    String home() {
        return "Hello World!";
    }

}