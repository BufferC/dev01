package com.fc.controller;

import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwitchController {
    @RequestMapping("switch")
    public String test(Model model) {
        model.addAttribute("user", new User(1, "易烊千玺", 22, "四个字"));

        return "switch";
    }
}
