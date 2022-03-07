package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class UtilTest {
    @Test
    public void testFindById() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        System.out.println(studentDao.findById(1));

        MyBatisUtil.commit();
    }

    @Test
    public void test() {
        try {
            StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

            List<Student> students = studentDao.findAll();

            MyBatisUtil.commit();

            for (Student student : students) {
                System.out.println(student);
            }
        } catch (Exception e) {
            MyBatisUtil.rollback();
            e.printStackTrace();
        }
    }

}


