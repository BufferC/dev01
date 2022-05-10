package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogicController {
    @RequestMapping("logic")
    public String test(Model model) {
        model.addAttribute("value", null);
        model.addAttribute("num", 20);
        return "logic";
    }
}
