package com.fc.service.impl;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public PageInfo<Student> findAll(Integer pageNum, Integer pageSize) {
        // 开启分页操作
        PageHelper.startPage(pageNum, pageSize);

        List<Student> students = studentDao.findAll();

        return new PageInfo<>(students);
    }

    @Override
    public int add(Student student) {
        return studentDao.add(student);
    }

    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public int delete(Integer id) {
        return studentDao.delete(id);
    }
}
