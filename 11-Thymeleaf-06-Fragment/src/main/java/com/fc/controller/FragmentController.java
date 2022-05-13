package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FragmentController {
    @RequestMapping("fragment")
    public String test() {
        return "fragment";
    }

    @RequestMapping("fragment1")
    public String test1() {
        return "fragment1";
    }

    @RequestMapping("fragment2")
    public String test2(Model model) {
        // model相当于request请求。
        // session
        model.addAttribute("address", "木叶");
        model.addAttribute("name", "鸣人");
        return "fragment2";
    }
}
