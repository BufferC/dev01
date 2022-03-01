package com.fc.service.impl;

import com.fc.dao.StudentDao;
import com.fc.dao.impl.StudentDaoImpl;
import com.fc.entity.Student;
import com.fc.service.StudentService;
import com.fc.vo.PageInfo;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    // 数据访问层对象
    StudentDao studentDao = new StudentDaoImpl();

    // 此方法是用来获取PageInfo的，因为获取PageInfo需要传递两个参数
    // 问题就变成了如果获取两个参数：totalCount和list
    // 这两个参数都是和数据库相关的。
    // 业务逻辑层是不能直接操作数据库的
    // 需要一个dao对象
    // 没有就创建一个
    // 因为是接口，创建接口的实现类
    @Override
    public PageInfo<Student> getPageInfo(int pageNo, int pageSize) {
        // 通过dao对象获取每页显示的内容以及总数据量
        int totalCount = studentDao.getTotalCount();

        List<Student> list = studentDao.getList(pageNo, pageSize);

        return new PageInfo<>(pageNo, pageSize, totalCount, list);
    }
}
