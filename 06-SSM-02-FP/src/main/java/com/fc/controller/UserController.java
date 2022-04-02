package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("del")
    public Map<String,Object> del(String id){
        return userService.del(id);
    }

    @RequestMapping("updata")
    public Map<String,Object> updata(User user){
        return userService.updata(user);
    }

    @RequestMapping("list")
    public Map<String,Object> list(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,@RequestParam(value = "id" ,required = false) Integer id){
        return userService.list(pageNo,pageSize,id);
    }

    @RequestMapping("add")
    public Map<String,Object> add(User user){
        return userService.add(user);
    }
}
