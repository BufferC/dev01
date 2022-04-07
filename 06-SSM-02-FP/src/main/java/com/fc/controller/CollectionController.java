package com.fc.controller;

import com.fc.entity.Collection;
import com.fc.service.CollectionService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("collect")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @RequestMapping("add")
    public ResultVo add(Collection collection){
        return collectionService.add(collection);
    }

    @RequestMapping("del")
    public ResultVo del(Long id){
        return collectionService.del(id);
    }

    @RequestMapping("list")
    public ResultVo list(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Long id){
        return collectionService.list(pageNo,pageSize,id);
    }
    @RequestMapping("update")
    public ResultVo update(Collection collection){
        return collectionService.update(collection);
    }
}
