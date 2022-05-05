package com.fc.controller;

import com.fc.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
@Api(tags = "用户处理器", description = "用户相关的所有操作")
public class UserController {
    @PostMapping("getHeader")
    @ApiOperation("测试获取请求头")
    public String getHeader(HttpServletRequest request) {
        String authorization = request.getHeader("token");

        System.out.println("获取到的请求头：" + authorization);

        return "获取到的请求头：" + authorization;
    }

    @GetMapping("findAll")
    @ApiOperation(value = "查询所有用户",
            nickname = "查询所有用户（昵称）")
    public Map<String, Object> findAll() {

        Map<String, Object> map = new HashMap<>();

        map.put("code", 200);
        map.put("message", "查询成功");
        map.put("success", true);
        map.put("data", new User(1, "易烊千玺", "12456"));

        return map;
    }

    @PutMapping("update")
    @ApiOperation("修改学生")
    public String update() {
        return "update user";
    }

    @DeleteMapping("delete")
    @ApiOperation("删除学生")
    public String delete(@ApiParam(name = "id",
            value = "用户的编号",
    defaultValue = "默认值为100，能够查询id为100的用户",
    example = "100",
    // 允许的值，可以使用多种表达式来指定
    allowableValues = "range[1,100]")
                             @RequestParam(defaultValue = "100") Integer id) {
        System.out.println("delete user:" + id);

        return "delete user:" + id;
    }

    @PostMapping("add")
    @ApiOperation("添加学生")
    public String add() {
        return "add user";
    }

    @GetMapping("getUser")
    @ApiOperation("获取学生")
    public User getUser() {
        return new User(1, "易烊千玺", "12456");
    }
}
