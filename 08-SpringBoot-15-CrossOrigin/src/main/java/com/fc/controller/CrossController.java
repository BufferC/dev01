package com.fc.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cross")
@CrossOrigin(originPatterns = "*", allowCredentials = "true",
        maxAge = 3600, methods = {
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE,
        RequestMethod.GET,
        RequestMethod.OPTIONS})
public class CrossController {
    @GetMapping("test")
    public String test() {
        return "苏州";
    }
}
