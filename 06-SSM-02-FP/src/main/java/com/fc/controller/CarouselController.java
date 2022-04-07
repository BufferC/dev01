package com.fc.controller;

import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    @RequestMapping("getList")
    public ResultVo getList(@RequestParam(value = "id",required = false)int id, @RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        return carouselService.getList(id, pageNo, pageSize);
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
