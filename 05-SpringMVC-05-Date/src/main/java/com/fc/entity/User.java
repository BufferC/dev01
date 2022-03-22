package com.fc.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String name;
    private Integer age;
    private String gender;
    private Date birthday;
    private String info;
}
