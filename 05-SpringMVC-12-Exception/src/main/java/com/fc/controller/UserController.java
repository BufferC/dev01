package com.fc.controller;

import com.fc.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("exception")
public class UserController {
    @RequestMapping("system")
    public String testSystemException() {
        int num = 1 / 0;
        return "/index.jsp";
    }

    @RequestMapping("custom")
    public void testCustomException() throws MyException {

        throw new MyException();
    }
}
