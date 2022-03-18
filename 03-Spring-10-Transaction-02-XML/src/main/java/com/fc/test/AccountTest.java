package com.fc.test;

import com.fc.service.AccountService;
import com.fc.service.impl.StatementServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService accountService = applicationContext.getBean(StatementServiceImpl.class);

        accountService.transfer(1, 2, 500L);
    }
}
