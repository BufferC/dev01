package com.fc.test;

import com.fc.dao.DepartmentDao;
import com.fc.entity.Department;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

public class LazyLoadTest {
    @Test
    public void test() {
        DepartmentDao departmentDao = MyBatisUtil.getMapper(DepartmentDao.class);

        Department department = departmentDao.findByDepartmentId(1);

        System.out.println(department);

        MyBatisUtil.commit();
    }
}
