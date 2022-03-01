package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    @Test
    public void testAdd() {
        SqlSession session = null;

        try {
            // 读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 获取工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            // 获取连接
            session = factory.openSession();

            // 执行指定的SQL语句
            int affectedRows = session.insert("StudentMapper.add");

            // 所有的增删改操作都需要进行提交
            session.commit();

            System.out.println("受影响的行数：" + affectedRows);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void testSelect() {
        try {
            // 读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 获取sqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 获取sqlSession，这个东西就类似queryRunner。包含了所有对数据库的操作
            SqlSession session = sqlSessionFactory.openSession();

            // 执行指定明明空间下的指定sql语句
            Object o = session.selectOne("StudentMapper.select");

            System.out.println(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDao() {
        try {
            // 读取配置
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 获取会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            // 获取数据库连接
            SqlSession session = factory.openSession();

            // 获取接口的实现类对象
            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = studentDao.selectOne();

            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddOnDao() {
        try {
            // 读取配置
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 获取工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            // 获取连接
            SqlSession session = factory.openSession();

            // 获取接口的实现类对象
            StudentDao studentDao = session.getMapper(StudentDao.class);

            // 调用接口中的方法
            int affectedRows = studentDao.add();

            // 提交增删改操作
            session.commit();

            // 关闭连接
            session.close();

            System.out.println("受影响的行数：" + affectedRows);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindById() {
        // 读取配置
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 获取工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            // 获取连接
            SqlSession session = factory.openSession();

            // 获取接口的实现类
            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = studentDao.findById(4);

            System.out.println(student);

            // 提交
            session.commit();

            // 关闭连接
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
