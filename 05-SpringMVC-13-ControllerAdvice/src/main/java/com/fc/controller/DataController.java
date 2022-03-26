package com.fc.controller;

import com.fc.entity.Student;
import com.fc.entity.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("data")
public class DataController {
    @RequestMapping("getDate")
    @ResponseBody
    public Map<String, Object> getDate(Date date) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", date);

        return map;
    }

    @RequestMapping("getName")
    @ResponseBody
    public Map<String, Object> getName(Student student, Teacher teacher) {
        Map<String, Object> map = new HashMap<>();

        map.put("student", student);
        map.put("teacher", teacher);

        return map;
    }

    @RequestMapping("getCreateTime")
    @ResponseBody
    public Map<String, Object> getCreateTime(@ModelAttribute("createTime") Date createTime) {
        Map<String, Object> map = new HashMap<>();

        map.put("createTime", createTime);

        return map;
    }
}
