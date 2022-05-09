package com.fc.controller;

import com.fc.entity.Car;
import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("selective")
public class SelectiveExpressionController {
    @RequestMapping("test")
    public String testSelective(Model model) {
        User user = new User(1, "易烊千玺", 22, "男", "穿好衣服", new Car("五菱", "红色"));

        model.addAttribute("user", user);

        return "selective";
    }
}
