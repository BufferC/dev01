package com.fc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cross")
//@CrossOrigin(allowedHeaders = {"token"}, originPatterns = "*", allowCredentials = "true",
//        maxAge = 3600, methods = {
//        RequestMethod.POST,
//        RequestMethod.PUT,
//        RequestMethod.DELETE,
//        RequestMethod.GET,
//        RequestMethod.OPTIONS})
public class CrossController {
    @GetMapping("test")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String test() {
        return "苏州";
    }
}
