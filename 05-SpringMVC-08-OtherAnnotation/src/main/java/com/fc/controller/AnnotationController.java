package com.fc.controller;

import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("annotation")
public class AnnotationController {
    @RequestMapping(value = "testRequestParam")
    public String testRequestParam(@RequestParam(value = "userId", defaultValue = "1") String id) {

        System.out.println("从前端获取到的请求参数：" + id);

        return "/success.jsp";
    }

    @RequestMapping("page")
    public String page(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        System.out.println("当前页：" + pageNo + "，每页显示多少条数据：" + pageSize);

        return "/success.jsp";
    }

    @GetMapping(value = "user/{id}", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String getUser(@PathVariable("id") String id) {

        System.out.println("查询id为" + id + "的学生");

        return "查询id为" + id + "的学生";
    }

    @DeleteMapping(value = "user/{id}", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String deleteUser(@PathVariable("id") String id) {

        System.out.println("删除id为" + id + "的学生");

        return "删除id为" + id + "的学生";
    }

    @PutMapping(value = "user/{id}", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String updateUser(@PathVariable("id") String id) {

        System.out.println("修改id为" + id + "的学生");

        return "修改id为" + id + "的学生";
    }

    @PostMapping(value = "user/{id}", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String addUser(@PathVariable("id") String id) {

        System.out.println("添加id为" + id + "的学生");

        return "添加id为" + id + "的学生";
    }

    @RequestMapping("testJsonString")
    @ResponseBody
    public String testJsonString(@RequestBody String json) {
        System.out.println(json);

        return json;
    }

    @RequestMapping(value = "testJsonObject", consumes = "application/json; charset=UTF-8")
    public void testJsonObject(@RequestBody User user) {
        System.out.println(user);
    }
}
