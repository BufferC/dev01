package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.dao.UserDao;
import com.fc.entity.Student;
import com.fc.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void testUser() {
        // 加载配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            UserDao userDao = session.getMapper(UserDao.class);

            List<User> users = userDao.findAll();

            for (User user : users) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindById() {
        try {
            // 加载配置文件到流中
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 获取会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            // 获取连接
            SqlSession session = factory.openSession();

            // 通过反射获取接口的实现类
            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Student> students = studentDao.findAll();

            for (Student student : students) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
