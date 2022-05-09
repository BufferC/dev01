package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LinkExpressionController {
    @RequestMapping("test/link/test")
    public String testLinkTest() {
        return "link";
    }

    @RequestMapping("test/link/url")
    @ResponseBody
    public String testLinkUrl() {
        return "当前路径";
    }

    @RequestMapping("url")
    @ResponseBody
    public String testUrl() {
        return "绝对路径";
    }

    @RequestMapping("test/url")
    @ResponseBody
    public String url() {
        return "上级路径";
    }
}
