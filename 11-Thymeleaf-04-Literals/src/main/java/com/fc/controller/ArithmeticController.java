package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArithmeticController {
    @RequestMapping("arithmetic")
    public String test(Model model) {
        model.addAttribute("num", 100);
        return "arithmetic";
    }
}
