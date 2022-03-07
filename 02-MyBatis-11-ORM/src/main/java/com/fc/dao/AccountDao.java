package com.fc.dao;

import com.fc.entity.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();

    List<Account> findAllOnMap();
}
