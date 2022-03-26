package com.fc.advice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

@ControllerAdvice
public class DataBindAdvice {
    @InitBinder
    public void parseDate(WebDataBinder binder) {
        // 设置自定义的格式化器
        binder.addCustomFormatter(new CustomDateFormatter());
    }

    @InitBinder("student")
    public void bindStudent(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("student.");
    }

    @InitBinder("teacher")
    public void bindTeacher(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("teacher.");
    }

    @ModelAttribute("createTime")
    public Date getCreateTime() {
        System.out.println("controller执行之前...");

        return new Date();
    }
}
