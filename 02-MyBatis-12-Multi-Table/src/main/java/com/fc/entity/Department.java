package com.fc.entity;

import lombok.Data;

import java.util.List;

@Data
public class Department {
    private Integer id;
    private String name;
    private List<Employee> employees;
}
