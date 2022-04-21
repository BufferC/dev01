package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    public List<User> findAll() {
        return userService.findAll();
    }
    @RequestMapping("findById")
    public User findById(Integer id) {
        return userService.findById(id);
    }
    @RequestMapping("findCount")
    public Integer findCount() {
        return userService.findCount();
    }
    @RequestMapping("insert")
    public int insert(User user) {
        return userService.insert(user);
    }
    @RequestMapping("update")
    public int update(User user) {
        return userService.update(user);
    }
    @RequestMapping("delete")
    public int delete(Integer id) {
        return userService.delete(id);
    }
}
