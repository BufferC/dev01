package com.fc.controller;

import com.fc.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WithController {
    @RequestMapping("with")
    public String test(Model model) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person(1, "易烊千玺", 22, "男", "四个字"));
        persons.add(new Person(2, "迪丽热巴", 30, "女", "四个字"));

        model.addAttribute("persons", persons);

        return "with";
    }
}
