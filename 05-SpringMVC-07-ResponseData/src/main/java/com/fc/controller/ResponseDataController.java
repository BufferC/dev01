package com.fc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("response")
public class ResponseDataController {
    @RequestMapping("testVoid")
    public void testVoid() {
        System.out.println("测试void");
    }

    @RequestMapping("testString")
    public String testString() {
        System.out.println("测试String直接返回一个路径");
        return "/success.jsp";
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView() {
        // 模型和视图对象
        ModelAndView mv = new ModelAndView("/success.jsp");

        // 添加模型
        // 这个操作就相当于request.setAttribute(String, Object);
        mv.addObject("username", "易烊千玺");

        // 设置视图
        // 这个操作就相当于request.getRequestDispatcher("/success.jsp").forward(req, resp);
        //mv.setViewName("/success.jsp");

        return mv;
    }

    // ModelAndView对象可以直接通过方法形参的方式从Spring容器中获取
    @RequestMapping("testModelAndView2")
    public ModelAndView testModelAndView2(ModelAndView mv) {
        mv.addObject("username", "迪丽热巴");

        mv.setViewName("/success.jsp");

        return mv;
    }

    // 不使用ModelAndView，直接使用Model对象以及字符串直接跳转
    @RequestMapping("testModelAndView3")
    public String testModelAndView2(Model model) {
        // 设置模型
        model.addAttribute("username", "玛卡巴卡");

        return "/success.jsp";
    }

    @RequestMapping("testVoidRedirect")
    public void testVoidRedirect(HttpServletResponse response) {
        try {
            response.sendRedirect("/success.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("testVoidForward")
    public void testVoidForward(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("testStringRedirect")
    public String testStringRedirect() {
        return "redirect:/success.jsp";
    }

    @RequestMapping("testStringForward")
    public String testStringForward() {
        return "forward:/success.jsp";
    }

    @RequestMapping("testResponseBody")
    @ResponseBody
    public void testResponseBody() {
        System.out.println("测一下，看看还报不报错");
    }

    @RequestMapping(value = "testStringByResponseBody", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String testStringByResponseBody() {
        return "<h1 align='center' style='color: green'>易烊千玺</h1>";
    }

    @RequestMapping(value = "testJsonString", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String testJsonString() {
        return "{\"username\": \"" + "易烊千玺" + "\", \"password\": \"123456\"}";
    }

    @RequestMapping(value = "getJsonString", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String getJsonString() {
        User user = new User();
        user.setName("易烊千玺");
        user.setAge(22);
        user.setGender("男");
        user.setBirthday(new Date());
        user.setInfo("四个字");

        // 对象映射器
        ObjectMapper mapper = new ObjectMapper();

        String json = null;

        try {
            // 将对象转为json字符串
            json = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(json);

        return json;
    }

    @RequestMapping(value = "getJsonObject", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public User getJsonObject() {
        User user = new User();
        user.setName("易烊千玺");
        user.setAge(22);
        user.setGender("男");
        user.setBirthday(new Date());
        user.setInfo("四个字");

        return user;
    }

    @RequestMapping(value = "getMap", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>();

        User user = new User();
        user.setName("易烊千玺");
        user.setAge(22);
        user.setGender("男");
        user.setBirthday(new Date());
        user.setInfo("四个字");

        List<String> foods = new ArrayList<>();
        foods.add("火腿肠");
        foods.add("咸鸭蛋");
        foods.add("面包");
        foods.add("牛奶");
        foods.add("馒头");

        map.put("code", 200);
        map.put("message", "查询成功");
        map.put("data", user);
        map.put("foods", foods);

        return map;
    }
}

