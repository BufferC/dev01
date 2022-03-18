package com.fc.service.impl;

import com.fc.dao.AccountDao;
import com.fc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("annotationServiceImpl")
public class AnnotationServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ
    ,propagation = Propagation.REQUIRED, readOnly = false)
    public void transfer(Integer from, Integer to, Long money) {
        accountDao.decreaseMoney(from, money);

        int num = 1 / 0;

        accountDao.increaseMoney(to, money);
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
