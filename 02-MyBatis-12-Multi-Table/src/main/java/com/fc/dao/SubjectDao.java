package com.fc.dao;

import com.fc.entity.Subject;

import java.util.List;

public interface SubjectDao {
    List<Subject> findAllWithStudent();
}
