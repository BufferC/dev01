package com.fc.test;


import com.fc.dao.AccountDao;
import com.fc.entity.Account;
import com.fc.entity.TAcount;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class ORMTest {
    @Test
    public void testUnderscore() {
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);

        List<TAcount> acounts = accountDao.findById(1);

        System.out.println(acounts);

        MyBatisUtil.commit();
    }

    @Test
    public void testMap() {
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);

        List<Account> accounts = accountDao.findAllOnMap();

        for (Account account : accounts) {
            System.out.println(account);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void test() {
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);

        List<Account> accounts = accountDao.findAll();

        for (Account account : accounts) {
            System.out.println(account);
        }

        MyBatisUtil.commit();
    }
}


