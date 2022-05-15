package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CtxController {
    @RequestMapping("ctx")
    public String test(Model model, HttpServletRequest request) {
        // model和request效果一样，并且优先级还更高
        model.addAttribute("attr", "model");

        request.setAttribute("attr", "request");
        request.setAttribute("value", "request value");

        request.getSession(true).setAttribute("attr", "session");
        request.getServletContext().setAttribute("attr", "servletContext");

        // modelandview默认就是走的转发
        // 除非你自己写两个重定向
        return "ctx";
    }
}
