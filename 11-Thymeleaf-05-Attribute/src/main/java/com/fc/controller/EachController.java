package com.fc.controller;

import com.fc.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class EachController {
    @RequestMapping("each")
    public String each(Model model) {
        ArrayList<Person> persons = new ArrayList<>();

        persons.add(new Person(1, "易烊千玺", 22, "男", "四个字"));
        persons.add(new Person(2, "迪丽热巴", 30, "女", "四个字"));
        persons.add(new Person(3, "古力娜扎", 28, "女", "四个字"));

        model.addAttribute("persons", persons);

        // LinkedHashMap是一个有序的HashMap
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", 1);
        map.put("name", "易烊千玺");
        map.put("age", 22);
        map.put("gender", true);
        map.put("info", "四个字");

        model.addAttribute("map", map);

        Map<String, Person> mapContainsObject = new LinkedHashMap<>();

        mapContainsObject.put("person1", new Person(1, "易烊千玺", 22, "男", "四个字"));
        mapContainsObject.put("person2", new Person(2, "迪丽热巴", 30, "女", "四个字"));
        mapContainsObject.put("person3", new Person(3, "古力娜扎", 28, "女", "四个字"));

        model.addAttribute("mapContainsObject", mapContainsObject);

        ArrayList<Map<String, Person>> maps = new ArrayList<>();

        Map<String, Person> map1 = new LinkedHashMap<>();
        map1.put("person1", new Person(1, "易烊千玺", 22, "男", "四个字"));
        map1.put("person2", new Person(2, "迪丽热巴", 30, "女", "四个字"));
        map1.put("person3", new Person(3, "古力娜扎", 28, "女", "四个字"));

        Map<String, Person> map2 = new LinkedHashMap<>();
        map2.put("person4", new Person(4, "玛卡巴卡", 3, "男", "四个字"));
        map2.put("person5", new Person(5, "依古比古", 4, "女", "四个字"));
        map2.put("person6", new Person(6, "汤不里不", 5, "女", "四个字"));

        Map<String, Person> map3 = new LinkedHashMap<>();
        map3.put("person7", new Person(7, "鱼香肉丝", 100, "男", "四个字"));
        map3.put("person8", new Person(8, "宫保鸡丁", 120, "女", "四个字"));
        map3.put("person9", new Person(9, "老弟盖饭", 150, "女", "四个字"));
        map3.put("person10", new Person(10, "糖醋排骨", 160, "女", "四个字"));
        map3.put("person11", new Person(11, "麻婆豆腐", 170, "女", "四个字"));

        maps.add(map1);
        maps.add(map2);
        maps.add(map3);

        model.addAttribute("maps", maps);

        String[] array = new String[4];

        array[0] = "奈克赛斯1";
        array[1] = "奈克赛斯2";
        array[2] = "奈克赛斯3";
        array[3] = "奈克赛斯4";

        model.addAttribute("array", array);

        return "each";
    }
}
