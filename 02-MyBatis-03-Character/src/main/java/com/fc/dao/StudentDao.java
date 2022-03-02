package com.fc.dao;

import com.fc.entity.Student;

import java.util.List;

public interface StudentDao {
    // 查询所有小于指定年龄的学生
    List<Student> findLessThanAge(Integer age);

    // 查询所有大于指定年龄的学生
    List<Student> findGreaterThanAge(Integer age);
}
