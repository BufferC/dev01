package com.fc.entity;

import lombok.Data;

import java.util.List;

@Data
public class Subject {
    private Integer id;
    private String name;
    private List<Student> students;
}
