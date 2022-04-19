package com.fc;

import com.fc.config.TestConfig;
import com.fc.entity.Car;
import com.fc.entity.Cat;
import com.fc.entity.Person;
import com.fc.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        TestConfig testConfig = applicationContext.getBean(TestConfig.class);

        // 这里获取的是代理对象
        System.out.println(testConfig);

        // 应该是不相同的
        User user1 = testConfig.getUser();
        User user2 = testConfig.getUser();

        // 应该是相同的
        User user3 = applicationContext.getBean(User.class);
        User user4 = applicationContext.getBean(User.class);

        System.out.println("new出来的：");
        System.out.println(user1);
        System.out.println(user2);

        System.out.println("从容器中获取到的：");
        System.out.println(user3);
        System.out.println(user4);

        System.out.println("------------");

        Person person = applicationContext.getBean(Person.class);

        Car car = applicationContext.getBean(Car.class);

        Car newCar = testConfig.getCar();

        person.setCar(newCar);

        System.out.println(person.getCar() == car);

        Object o = applicationContext.getBean("car");
        Object o1 = applicationContext.getBean("car1");
        Object o2 = applicationContext.getBean("car2");

        System.out.println("从容器中获取到的对象：" + o.hashCode());
        System.out.println("从容器中获取到的对象：" + o1.hashCode());
        System.out.println("从容器中获取到的对象：" + o2.hashCode());

        System.out.println("---------------");

        // 获取容器中所有的Bean的name
        String[] names = applicationContext.getBeanDefinitionNames();

        for (String name : names) {
            System.out.println(name);
        }

        Cat cat = applicationContext.getBean("com.fc.entity.Cat", Cat.class);

        System.out.println(cat);
    }

}
