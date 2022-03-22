package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("hello")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    // 访问不到
    @RequestMapping("login")
    public String login() {
        System.out.println("login");
        return "/WEB-INF/jsp/login.jsp";
    }

    @RequestMapping("add")
    public String add() {
        System.out.println("add");
        return "add";
    }

    @RequestMapping("delete")
    public String delete() {
        System.out.println("delete");
        return "delete";
    }

    @RequestMapping("update")
    public String update() {
        System.out.println("update");
        return "update";
    }
}
