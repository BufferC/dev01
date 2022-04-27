package com.fc.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Student implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Date birthday;
    private String info;
}
