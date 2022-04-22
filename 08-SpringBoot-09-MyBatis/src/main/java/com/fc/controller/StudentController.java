package com.fc.controller;

import com.fc.entity.Student;
import com.fc.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("findByPage")
    public PageInfo<Student> findByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "3") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<Student> students = studentService.findAll();

        return new PageInfo<>(students);
    }


    @RequestMapping("findAll")
    public List<Student> findAll() {
        return studentService.findAll();
    }
}
