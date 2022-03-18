package com.fc.dao.impl;

import com.fc.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void increaseMoney(Integer id, Long money) {
        // 执行SQL语句
        getJdbcTemplate().update("update account set money = money + ? where id = ?", money, id);

        System.out.println("加钱成功");
    }

    @Override
    public void decreaseMoney(Integer id, Long money) {
        // 执行SQL语句
        getJdbcTemplate().update("update account set money = money - ? where id = ?", money, id);

        System.out.println("扣款成功");
    }
}
