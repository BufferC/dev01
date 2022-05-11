package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IfController {
    @RequestMapping("if")
    public String test(Model model) {
        model.addAttribute("str1", "");
        model.addAttribute("str2", null);
        model.addAttribute("str3", "null");
        return "if";
    }
}
