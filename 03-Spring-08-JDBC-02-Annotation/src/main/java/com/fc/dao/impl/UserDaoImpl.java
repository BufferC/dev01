package com.fc.dao.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        String sql = "select * from user";

        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

        return users;
    }

    @Override
    public User findById(Integer id) {
        String sql = "select * from user where id = ?";

        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);

        return user;
    }

    @Override
    public int findCount() {
        String sql = "select count(1) from user";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);

        return count;
    }

    @Override
    public int insert(User user) {
        String sql = "insert into user(username, password) values(?, ?)";

        int affectedRows = jdbcTemplate.update(sql, user.getUsername(), user.getPassword());

        return affectedRows;
    }

    @Override
    public int update(User user) {
        String sql = "update user set password = ? where id = ?";

        int affectedRows = jdbcTemplate.update(sql, user.getPassword(), user.getId());
        return affectedRows;
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from user where id = ?";

        int affectedRows = jdbcTemplate.update(sql, id);
        return affectedRows;
    }
}
