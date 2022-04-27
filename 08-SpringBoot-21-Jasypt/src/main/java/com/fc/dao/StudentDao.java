package com.fc.dao;

import com.fc.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface StudentDao {
    List<Student> findAll();
}
