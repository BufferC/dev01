package com.fc.dao;

import com.fc.entity.Account;
import com.fc.entity.TAcount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();

    List<Account> findAllOnMap();

    List<TAcount> findById(@Param("id") Integer tId);
}
