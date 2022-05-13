package com.fc.controller;

import com.fc.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PrecedenceController {
    @RequestMapping("precedence")
    public String test(Model model) {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "易烊千玺", 22, "四个字"));
        students.add(new Student(2, "迪丽热巴", 30, "四个字"));
        students.add(new Student(3, "玛卡巴卡", 3, "四个字"));

        model.addAttribute("students", students);

        Map<String, String> location = new HashMap<>();

        location.put("1", "郑州");
        location.put("2", "杭州");
        location.put("3", "南京");
        location.put("4", "成都");
        location.put("5", "苏州");

        model.addAttribute("location", location);
        model.addAttribute("selected", "苏州");

        return "precedence";
    }
}
