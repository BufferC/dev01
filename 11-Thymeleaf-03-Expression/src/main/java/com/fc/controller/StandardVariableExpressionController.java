package com.fc.controller;

import com.fc.entity.Car;
import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("variable")
public class StandardVariableExpressionController {
    @RequestMapping("test")
    public String test(Model model) {
        model.addAttribute("name", "易烊千玺");
        model.addAttribute("age", 22);
        model.addAttribute("married", false);

        User user = new User(1, "易烊千玺", 22, "男", "四个字", new Car("五菱", "粉红色"));

        model.addAttribute("user", user);

        return "variable";
    }

    @RequestMapping("test1")
    public String test1(HttpServletRequest request) {
        request.setAttribute("name", "迪丽热巴");
        request.setAttribute("age", 30);
        request.setAttribute("married", false);

        User user = new User(2, "迪丽热巴", 30, "男", "四个字", new Car("五菱", "粉红色"));

        request.setAttribute("user", user);

        return "variable";
    }
}
