package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("response")
public class ResponseDataController {
    @RequestMapping("testVoid")
    public void testVoid() {
        System.out.println("测试void");
    }

    @RequestMapping("testString")
    public String testString() {
        System.out.println("测试String直接返回一个路径");
        return "/success.jsp";
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView() {
        // 模型和视图对象
        ModelAndView mv = new ModelAndView("/success.jsp");

        // 添加模型
        // 这个操作就相当于request.setAttribute(String, Object);
        mv.addObject("username", "易烊千玺");

        // 设置视图
        // 这个操作就相当于request.getRequestDispatcher("/success.jsp").forward(req, resp);
        //mv.setViewName("/success.jsp");

        return mv;
    }

    // ModelAndView对象可以直接通过方法形参的方式从Spring容器中获取
    @RequestMapping("testModelAndView2")
    public ModelAndView testModelAndView2(ModelAndView mv) {
        mv.addObject("username", "迪丽热巴");

        mv.setViewName("/success.jsp");

        return mv;
    }

    // 不使用ModelAndView，直接使用Model对象以及字符串直接跳转
    @RequestMapping("testModelAndView3")
    public String testModelAndView2(Model model) {
        // 设置模型
        model.addAttribute("username", "玛卡巴卡");

        return "/success.jsp";
    }
}
