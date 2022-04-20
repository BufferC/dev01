package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("jsp")
public class JspController {
    @RequestMapping("test")
    public ModelAndView getJsp(ModelAndView mv) {

        mv.addObject("username", "迪丽热巴");

        mv.setViewName("index");

        return mv;
    }
}
