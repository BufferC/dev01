package com.fc.test;

import com.fc.config.AopConfig;
import com.fc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
    @Test
    public void testAnnotation() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);

        UserService userService = applicationContext.getBean(UserService.class);

        userService.add();
        userService.update();
    }

    @Test
    public void testXml() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = applicationContext.getBean(UserService.class);

        userService.add();

        System.out.println("------------华丽-----------");

        userService.update();
    }
}
