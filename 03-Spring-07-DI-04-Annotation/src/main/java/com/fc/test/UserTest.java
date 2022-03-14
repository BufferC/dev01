package com.fc.test;

import com.fc.controller.UserController;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void testContext() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserController controller = applicationContext.getBean(UserController.class);

        List<User> list = controller.findAll();

        System.out.println(list);
    }

    @Test
    public void test() {
        UserController controller = new UserController();

        List<User> list = controller.findAll();

        System.out.println(list);
    }
}
