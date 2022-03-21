package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @RequestMapping用于声明请求的映射url路径，也能加/，也可以不加
@RequestMapping("user")
public class UserController {
    // 方法生的@RequestMapping相当于二级路径
    @RequestMapping("login")
    public String login() {
        System.out.println("登录成功！");

        // 从根路径去访问
        return "/login.jsp";
    }

    @RequestMapping("register")
    public String register() {
        System.out.println("注册成功！");

        // 从根路径去访问
        return "/login.jsp";
    }

    @RequestMapping("insert")
    public String insert() {
        System.out.println("插入成功！");

        // 从根路径去访问
        return "/login.jsp";
    }

    @RequestMapping("delete")
    public String delete() {
        System.out.println("删除成功！");

        // 从根路径去访问
        return "/login.jsp";
    }
}
