package com.fc.test;

import com.fc.entity.Car;
import com.fc.entity.Person;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetTest {
    static ApplicationContext applicationContext = null;

    @BeforeClass
    public static void before() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("获取容器");
    }

    @AfterClass
    public static void after() {
        System.out.println("关闭容器");

        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

    @Test
    public void test1() {
        Car car = applicationContext.getBean(Car.class);

        Person person = applicationContext.getBean(Person.class);

        System.out.println(car);
        System.out.println(person);
    }

    @Test
    public void test2() {
        Car car = applicationContext.getBean(Car.class);

        Person person = applicationContext.getBean(Person.class);

        System.out.println(car);
        System.out.println(person);
    }

    @Test
    public void test3() {
        Car car = applicationContext.getBean(Car.class);

        Person person = applicationContext.getBean(Person.class);

        System.out.println(car);
        System.out.println(person);
    }
}
