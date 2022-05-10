package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TernaryController {
    @RequestMapping("ternary")
    public String test(Model model) {
        model.addAttribute("name", "易烊千玺");
        model.addAttribute("age", 22);
        model.addAttribute("gender", true);
        return "ternary";
    }
}
