package com.fc.service;

import com.fc.entity.Student;
import com.fc.vo.PageInfo;

// 业务层接口
public interface StudentService {
    // 获取PageInfo对象
    PageInfo<Student> getPageInfo(int pageNo, int pageSize);
}
