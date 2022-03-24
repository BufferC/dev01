package com.fc.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class User {
    private String name;
    private Integer age;
    private String gender;
    // 接收的类型就是-类型了
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}
