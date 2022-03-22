package com.fc.controller;

import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("register")
    public String register(User user) {
        System.out.println(user);

        return "/success.jsp";
    }
}
