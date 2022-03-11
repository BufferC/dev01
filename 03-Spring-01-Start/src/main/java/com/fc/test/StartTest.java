package com.fc.test;

import com.fc.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartTest {
    @Test
    public void test() {
        // 获取Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 获取Bean对象
        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);

        userDao.findAll();
    }
}
