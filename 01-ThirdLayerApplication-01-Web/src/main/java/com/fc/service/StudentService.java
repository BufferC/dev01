package com.fc.service;

import com.fc.entity.Student;
import com.fc.vo.PageInfo;

public interface StudentService {
    PageInfo<Student> getPageInfo(int pageNo, int pageSize);
}
