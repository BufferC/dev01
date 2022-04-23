package com.fc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class FilterController {
    @RequestMapping("filter")
    public String test() {
        System.out.println("控制器1被执行");
        return "控制器1被执行";
    }

    @RequestMapping("filter2")
    public String test2() {
        System.out.println("控制器2被执行");
        return "控制器2被执行";
    }
}
