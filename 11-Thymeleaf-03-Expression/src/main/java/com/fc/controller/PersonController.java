package com.fc.controller;

import com.fc.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("person")
public class PersonController {
    @RequestMapping("test")
    public String test(Model model) {
        model.addAttribute("person", new Person(1, "易烊千玺", "123456"));
        return "person";
    }

    @RequestMapping("getParam")
    @ResponseBody
    public Person getParam(Person person) {
        return person;
    }

    @RequestMapping("getRestful/{id}/{username}/{password}")
    @ResponseBody
    public Person getRestful(@PathVariable("id") Integer id,
                             @PathVariable("username") String username,
                             @PathVariable("password") String password) {
        return new Person(id, username, password);
    }
}
