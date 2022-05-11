package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TextController {
    @RequestMapping("text")
    public String test(Model model) {
        model.addAttribute("text", "<h1 style='color: red'>欢迎</>");
        model.addAttribute("entity", "&gt;");

        return "text";
    }
}
