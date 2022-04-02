package com.fc.controller;

import com.fc.entity.Collection;
import com.fc.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("collect")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @RequestMapping("add")
    public Map<String,Object> add(Collection collection){
        return collectionService.add(collection);
    }

    @RequestMapping("del")
    public Map<String,Object> del(String id){
        long userId = Long.parseLong(id);
        return collectionService.del(userId);
    }

    @RequestMapping("list")
    public Map<String,Object> list(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, @RequestParam(value = "id" ,required = false) Integer id){
        return collectionService.list(pageNo,pageSize,id);
    }
}
