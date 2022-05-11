package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RemoveController {
    @RequestMapping("remove")
    public String test() {
        return "remove";
    }
}
