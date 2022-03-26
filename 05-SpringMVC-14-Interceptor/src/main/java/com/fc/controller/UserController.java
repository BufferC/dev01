package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping(value = "test")
    public ModelAndView test(ModelAndView mv) {
        System.out.println("Controller正在执行");

        mv.addObject("message", "打卡");

        mv.setViewName("/index.jsp");

        return mv;
    }
}
