package com.fc.controller;

import com.fc.entity.Collection;
import com.fc.service.CollectionService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @RequestMapping("add")
    public ResultVo add(@RequestBody Collection collection){
        return collectionService.add(collection);
    }

    @RequestMapping("delete")
    public ResultVo del(Long id){
        return collectionService.del(id);
    }

    @RequestMapping("getlist")
    public ResultVo list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, @RequestParam(value = "name",required = false)String name){
        return collectionService.list(pageNum,pageSize,name);
    }
    @RequestMapping("update")
    public ResultVo update(@RequestBody Collection collection){
        return collectionService.update(collection);
    }
}
