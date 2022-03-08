package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class CacheTest {
    @Test
    public void testTwo() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            System.out.println("第一次查询");
            studentDao.findById(10);

            session.commit();

            System.out.println("第二次查询");
            studentDao.findById(10);

            Student student = new Student();
            student.setId(10);
            student.setInfo("大魔王");

            studentDao.update(student);
            session.commit();

            System.out.println("第三次查询");
            studentDao.findById(10);

            session.close();

            SqlSession session2 = factory.openSession();

            StudentDao studentDao2 = session2.getMapper(StudentDao.class);

            System.out.println("第四次查询");
            studentDao2.findById(10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session1 = factory.openSession();
            SqlSession session2 = factory.openSession();

            StudentDao studentDao1 = session1.getMapper(StudentDao.class);
            StudentDao studentDao2 = session2.getMapper(StudentDao.class);

            Student student1 = studentDao1.findById(1);
            Student student2 = studentDao2.findById(1);

            System.out.println(student1 == student2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
