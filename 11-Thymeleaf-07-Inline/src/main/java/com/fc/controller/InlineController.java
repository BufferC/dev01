package com.fc.controller;

import com.fc.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InlineController {
    @RequestMapping("inline")
    public String test(Model model) {
        model.addAttribute("html", "<h1 align='center'>易烊千玺</h1>");

        model.addAttribute("name", "易烊千玺");
        model.addAttribute("num", 22);
        model.addAttribute("boolean", true);
        model.addAttribute("student", new Student(1, "易烊千玺", "123455"));


        model.addAttribute("class", "class");
        model.addAttribute("color", "red");
        model.addAttribute("align", "center");

        return "inline";
    }
}
