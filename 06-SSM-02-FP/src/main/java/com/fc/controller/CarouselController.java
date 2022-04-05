package com.fc.controller;

import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    @RequestMapping("getlist")
    public Map<String,Object> getList(@RequestParam(value = "id",required = false) String id, @RequestParam(value = "pageNo",defaultValue = "1") String pageNo, @RequestParam(value = "pageSize",defaultValue = "5") String pageSize){
        List<Carousel> carousels = carouselService.getList(pageNo,pageSize,id);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> maps = new HashMap<>();
        if (carousels.isEmpty()){
            maps.put("errMsg","错误描述");
            map.put("message","获取失败!");
            map.put("code",404);
            map.put("success",false);
            map.put("data",maps);
        }else {
            maps.put("total",carouselService.count());
            maps.put("list",carousels);
            maps.put("pageNum",pageNo);
            maps.put("pageSize",pageSize);
            map.put("message","获取成功!");
            map.put("code",200);
            map.put("success",true);
            map.put("data",maps);
        }
        return map;
    }

    @RequestMapping("add")
    public Map<String,Object> add(Carousel carousel){
        Carousel car = carouselService.add(carousel);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> maps = new HashMap<>();
        if (car != null){
            maps.put("total",carouselService.count());
            maps.put("list",car);
            map.put("message","添加成功!");
            map.put("code",200);
            map.put("success",true);
            map.put("data",maps);

        }else {
            maps.put("errMsg","错误描述");
            map.put("message","添加失败!");
            map.put("code",404);
            map.put("success",false);
            map.put("data",maps);
        }
        return map;
    }

    @RequestMapping("update")
    public Map<String,Object> update(@RequestParam(value = "id" )int id, @RequestParam(value = "name",required = false) String name, @RequestParam(value = "picture",required = false) String picture,@RequestParam(value = "available",required = false) Integer available){
        Carousel carousel = carouselService.update(id,name,picture,available);
        Boolean aBoolean = carousel.getAvailable();

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> maps = new HashMap<>();
        if (carousel != null){
            maps.put("list",carousel);
            map.put("message","添加成功!");
            map.put("code",200);
            map.put("success",true);
            map.put("data",maps);

        }else {
            maps.put("errMsg","错误描述");
            map.put("message","添加失败!");
            map.put("code",404);
            map.put("success",false);
            map.put("data",maps);
        }
        return map;
    }

    @RequestMapping("delete")
    public Map<String,Object> delete(String id){
        int delete = carouselService.delete(id);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> maps = new HashMap<>();
        if (delete == 1){
            map.put("message","删除成功!");
            map.put("code",200);
            map.put("success",true);
            map.put("data",delete);

        }else {
            maps.put("errMsg","错误描述");
            map.put("message","删除失败!");
            map.put("code",404);
            map.put("success",false);
            map.put("data",maps);
        }
        return map;
    }
}
