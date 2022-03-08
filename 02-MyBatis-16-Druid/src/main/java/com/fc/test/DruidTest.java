package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

public class DruidTest {
    @Test
    public void test() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        studentDao.findAll();

        MyBatisUtil.commit();
    }
}
