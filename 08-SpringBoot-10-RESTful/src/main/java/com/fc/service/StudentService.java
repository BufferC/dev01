package com.fc.service;

import com.fc.entity.Student;
import com.github.pagehelper.PageInfo;

public interface StudentService {
    PageInfo<Student> findAll(Integer pageNum, Integer pageSize);

    int add(Student student);

    int update(Student student);

    int delete(Integer id);
}
