package com.fc.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @PostMapping("{username}/{password}")
    public String add(@PathVariable("username") String username,
                      @PathVariable("password") String password) {
        return "添加操作被执行！" + username + "：" + password;
    }

    @GetMapping
    public String query() {
        return "查询操作被执行！";
    }

    @PutMapping("{id}/{username}/{password}")
    public String update(@PathVariable("id") Integer id,
                         @PathVariable("username") String username,
                         @PathVariable("password") String password) {
        return "修改操作被执行！" + id + "：" + username + "：" + password;
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Integer id) {
        return "删除操作被执行！" + id;
    }
}
