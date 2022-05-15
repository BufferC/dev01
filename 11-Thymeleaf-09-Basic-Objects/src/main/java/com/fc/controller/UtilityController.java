package com.fc.controller;

import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class UtilityController {
    @RequestMapping("uris")
    public String testUris() {
        return "uris";
    }

    @RequestMapping("dates")
    public String testDates(Model model) {
        // 日期
        model.addAttribute("date", new Date());

        // 数组
        Date[] array = {new Date(120, 0, 1, 1, 1, 1), new Date(110, 6, 3, 12, 12, 12)};
        model.addAttribute("array", array);

        // list
        List<Date> list = new ArrayList<>();
        list.add(new Date(120, 1, 1, 1, 1, 1));
        list.add(new Date(120, 2, 2, 2, 2, 2));
        model.addAttribute("list", list);

        // set
        Set<Date> set = new HashSet<>();
        set.add(new Date(120, 1, 1, 1, 1, 1));
        set.add(new Date(120, 2, 2, 2, 2, 2));
        model.addAttribute("set", set);

        return "dates";
    }

    @RequestMapping("strings")
    public String testStrings(Model model) {
        model.addAttribute("user", new User(1, "易烊千玺", 21));
        model.addAttribute("text", "HelloWorld");

        return "strings";
    }

    @RequestMapping("nums")
    public String testNums(Model model) {
        return "numbers";
    }
}
