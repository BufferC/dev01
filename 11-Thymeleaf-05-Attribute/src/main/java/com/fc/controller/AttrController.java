package com.fc.controller;

import com.fc.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AttrController {
    @RequestMapping("attr")
    public String test(Model model) {
        Student student = new Student();

        student.setId(1);
        student.setName("易烊千玺");
        student.setAge(22);
        student.setInfo("四个字");

        model.addAttribute("action", "getStudent");
        model.addAttribute("student", student);
        model.addAttribute("checked", true);
        model.addAttribute("method", "post");

        return "attr";
    }

    @PostMapping("getStudent")
    @ResponseBody
    public Student getStudent(Student student) {
        return student;
    }
}
