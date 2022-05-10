package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class BooleanController {
    @RequestMapping("boolean")
    public String test(Model model) {
        model.addAttribute("boolean", true);
        model.addAttribute("age", 22);

        // 模拟云日记的写法
        // 如果数据库中没查出来，那这里就是一个null
        ArrayList<String> notes = new ArrayList<>();

        notes.add("美食1：今天吃了饭");
        notes.add("美食2：今天吃了饭");
        notes.add("美食3：今天吃了饭");

        model.addAttribute("notes", notes);

        return "boolean";
    }
}
