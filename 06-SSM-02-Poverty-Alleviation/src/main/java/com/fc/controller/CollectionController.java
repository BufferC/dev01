package com.fc.controller;

import com.fc.entity.Collection;
import com.fc.service.CollectionService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 收藏管理
@RestController
@RequestMapping("collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @GetMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize,
                            Long id) {
        return collectionService.getList(pageNum, pageSize, id);
    }

    @PostMapping("add")
    public ResultVO add(@RequestBody Collection collection) {
        return collectionService.add(collection);
    }

    @PostMapping("update")
    public ResultVO update(@RequestBody Collection collection) {
        return collectionService.update(collection);
    }

    @GetMapping("delete")
    public ResultVO delete(Long id) {
        return collectionService.delete(id);
    }
}
