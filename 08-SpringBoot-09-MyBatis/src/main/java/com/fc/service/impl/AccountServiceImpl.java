package com.fc.service.impl;

import com.fc.dao.AccountDao;
import com.fc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Transactional(isolation = Isolation.DEFAULT,
    propagation = Propagation.REQUIRED,
    readOnly = false)
    @Override
    public void transfer(Integer from, Integer to, Integer money) {
        accountDao.decrease(from, money);

        int num = 1 / 0;

        accountDao.increase(to, money);
    }
}
