package com.fc.dao.impl;

import com.fc.dao.LocationDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class LocationDaoImpl extends JdbcDaoSupport implements LocationDao {
    @Override
    public void add(String location) {
        getJdbcTemplate().update("insert into location(name) values (?)", location);

        int num = 1 / 0;
    }
}
