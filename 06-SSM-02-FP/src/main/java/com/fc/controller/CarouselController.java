package com.fc.controller;

import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    @RequestMapping("getlist")
    public ResultVo getList(@RequestParam(value = "name",required = false)String name, @RequestParam(value = "pageNum",defaultValue = "1",required = false) Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize){
        return carouselService.getList(pageNum, pageSize,name);
    }

    @RequestMapping("add")
    public ResultVo add(@RequestBody Carousel carousel){
        return carouselService.add(carousel);
    }

    @RequestMapping("update")
    public ResultVo update(@RequestBody Carousel carousel){
        return carouselService.update(carousel);
    }

    @RequestMapping("delete")
    public ResultVo delete(int id){
        return carouselService.delete(id);
    }
}
