package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentDao {
    Student findById(@Param("id") Integer id);

    int update(Student student);
}
