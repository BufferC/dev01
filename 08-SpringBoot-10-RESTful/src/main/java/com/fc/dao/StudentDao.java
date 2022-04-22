package com.fc.dao;

import com.fc.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    List<Student> findAll();

    int add(Student student);

    int update(Student student);

    int delete(Integer id);
}
