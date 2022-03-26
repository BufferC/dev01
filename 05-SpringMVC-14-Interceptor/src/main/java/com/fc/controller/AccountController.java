package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {
    @RequestMapping("getFoods")
    public ModelAndView getFoods(ModelAndView mv) {
        System.out.println("连接数据库...");

        List<String> list = new ArrayList<>();

        list.add("茄子");
        list.add("芹菜");
        list.add("大葱");
        list.add("韭菜");
        list.add("香菜");
        list.add("蒜薹");
        list.add("萝卜");
        list.add("洋葱");
        list.add("海带");
        list.add("蒜");
        list.add("苦瓜");
        list.add("丝瓜");

        mv.addObject("foods", list);

        mv.setViewName("/account/getFoods");

        return mv;
    }
}
