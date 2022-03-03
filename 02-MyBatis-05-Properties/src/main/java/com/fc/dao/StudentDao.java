package com.fc.dao;

import com.fc.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
}
