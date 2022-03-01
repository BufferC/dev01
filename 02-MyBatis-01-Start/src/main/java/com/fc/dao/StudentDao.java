package com.fc.dao;

import com.fc.entity.Student;

public interface StudentDao {
    Student selectOne();

    int add();

    /**
     * 通过id查询学生
     * @param id id
     * @return 学生
     */
    Student findById(Integer id);
}
