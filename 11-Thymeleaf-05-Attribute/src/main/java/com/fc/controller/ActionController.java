package com.fc.controller;

import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ActionController {
    @RequestMapping("action")
    public String test(Model model) {
        model.addAttribute("user", new User(1, "易烊千玺", 22, "四个字"));
        model.addAttribute("method", "post");

        return "action";
    }

    @PostMapping("update")
    @ResponseBody
    public User getUser(User user) {
        return user;
    }
}
