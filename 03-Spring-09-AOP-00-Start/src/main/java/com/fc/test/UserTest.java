package com.fc.test;

import com.fc.dao.impl.UserDaoImpl;
import org.junit.Test;

public class UserTest {
    @Test
    public void test() {
        UserDaoImpl userDao = new UserDaoImpl();

        userDao.findAll();
    }
}
