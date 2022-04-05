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

    @RequestMapping("delete")
    public Map<String,Object> del(String id){
        return userService.del(id);
    }

    @RequestMapping("update")
    public Map<String,Object> updata(User user){
        return userService.updata(user);
    }

    @RequestMapping("getlist")
    public Map<String,Object> list(@RequestParam(value = "pageNo",defaultValue = "1") String pageNo,@RequestParam(value = "pageSize",defaultValue = "5") String pageSize,@RequestParam(value = "id" ,required = false) String id){
        return userService.list(pageNo,pageSize,id);
    }

    @RequestMapping("add")
    public Map<String,Object> add(User user){
        return userService.add(user);
    }
}
