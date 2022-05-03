package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户管理", description = "用户相关的所有操作")
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("用户登录")
    @PostMapping("login")
    public ResultVO login(@RequestParam String username,
                          @RequestParam String password) {
        return userService.login(username, password);
    }

    @ApiOperation(value = "查询用户", notes = "分页查询，模糊查询，根据id查询")
    @GetMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize,
                            User user) {
        return userService.getList(pageNum, pageSize, user);
    }

    @ApiOperation("添加用户")
    @PostMapping("add")
    public ResultVO add(@RequestBody User user) {
        return userService.add(user);
    }

    @ApiOperation("修改用户")
    @PostMapping("update")
    public ResultVO update(@RequestBody User user) {
        return userService.update(user);
    }

    @ApiOperation("删除用户")
    @GetMapping("delete")
    public ResultVO delete(Long id) {
        return userService.delete(id);
    }
}
