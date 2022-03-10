package com.fc.test;

import com.fc.dao.impl.UserDaoMySQLImpl;
import com.fc.service.UserService;
import com.fc.service.impl.UserServiceImpl;
import org.junit.Test;

public class ThreeTest {
    @Test
    public void test() {
        UserService userService = new UserServiceImpl();

        userService.setUserDao(new UserDaoMySQLImpl());

        userService.useJDBC();
    }
}
