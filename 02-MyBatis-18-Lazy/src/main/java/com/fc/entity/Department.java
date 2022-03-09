package com.fc.entity;

import lombok.Data;

import java.util.List;

@Data
public class Department {
    private Integer id;
    private String name;
    // 一个部门中有多个员工
    private List<Employee> employees;
}
