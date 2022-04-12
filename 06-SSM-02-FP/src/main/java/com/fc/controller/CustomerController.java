package com.fc.controller;

import com.fc.entity.Customer;
import com.fc.service.CustomerService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("login")
    public ResultVo login(Customer customer){
       return customerService.login(customer.getUsername(), customer.getPassword());
    }

    @RequestMapping("verifyToken")
    public Map<String, Object> verify(String token) {
        return customerService.verify(token);
    }

}
