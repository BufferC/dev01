package com.fc.test;

import com.fc.config.TxtConfig;
import com.fc.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {
    @Test
    public void testAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxtConfig.class);

        AccountService service = applicationContext.getBean("annotationServiceImpl", AccountService.class);

        service.transfer(1, 2, 500L);
    }

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService accountService = applicationContext.getBean("annotationService", AccountService.class);

        accountService.transfer(1, 2, 500L);
    }
}
