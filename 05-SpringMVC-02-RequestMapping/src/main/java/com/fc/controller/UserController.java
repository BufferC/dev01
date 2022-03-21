package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    // SpringMVC中不需要通过request.getParameter()来获取参数了。可以直接在方法上声明
    @RequestMapping("getParam")
    public void getParam(String username, String password) {
        System.out.println("用户名：" + username + " 密码：" + password);
    }
}
