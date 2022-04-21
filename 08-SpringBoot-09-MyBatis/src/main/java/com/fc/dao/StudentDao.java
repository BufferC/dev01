package com.fc.dao;

import com.fc.entity.Student;

import java.util.List;
// 其实没用
//@Mapper
public interface StudentDao {
    List<Student> findAll();
}
