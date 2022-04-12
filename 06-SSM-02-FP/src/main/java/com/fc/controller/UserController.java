package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("delete")
    public ResultVo del(Long id){
        return userService.del(id);
    }

    @RequestMapping("update")
    public ResultVo update(@RequestBody User user){
        return userService.update(user);
    }

    @RequestMapping("getlist")
    public ResultVo list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Long id){
        return userService.list(pageNum,pageSize,id);
    }

    @RequestMapping("add")
    public ResultVo add(@RequestBody User user){
        return userService.add(user);
    }
}
