package com.fc.dao;

import com.fc.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
}
