package com.fc.service.impl;

import com.fc.dao.StudentDao;
import com.fc.dao.impl.StudentDaoImpl;
import com.fc.entity.Student;
import com.fc.service.StudentService;
import com.fc.vo.PageInfo;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public PageInfo<Student> getPageInfo(int pageNo, int pageSize) {
        int totalCount = studentDao.getTotalCount();

        List<Student> list = studentDao.getList(pageNo, pageSize);

        return new PageInfo<>(totalCount, pageSize, pageNo, list);
    }
}
