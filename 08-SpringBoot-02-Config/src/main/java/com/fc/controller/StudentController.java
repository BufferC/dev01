package com.fc.controller;

import com.fc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("student")
public class StudentController {
    @Value("${student.name}")
    private String name;
    @Value("${student.age}")
    private Integer age;
    @Value("${student.gender}")
    private String gender;
    @Value("${student.married}")
    private Boolean married;
    @Value("${student.birthday}")
    private Date birthday;
    // 约定
    @Value("${student.info:五个字}")
    private String info;

    @Autowired
    private Student student;

    @RequestMapping("getStudent")
    public Student getStudent() {
        return student;
    }

    @RequestMapping("test")
    public Map<String, Object> testYml() {
        Map<String, Object> map = new HashMap<>();

        map.put("name", name);
        map.put("age", age);
        map.put("gender", gender);
        map.put("married", married);
        map.put("birthday", birthday);
        map.put("info", info);
        return map;
    }
}
