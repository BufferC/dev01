package com.fc.controller;

import com.fc.entity.Alleviation;
import com.fc.service.AlleviationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("policy")
public class AlleviationController {
    @Autowired
    private AlleviationService alleviationService;

    @RequestMapping("add")
    public Map<String,Object> add(Alleviation alleviation){
        return alleviationService.add(alleviation);
    }

    @RequestMapping("updata")
    public Map<String,Object> updata(Alleviation alleviation){
        return alleviationService.updata(alleviation);
    }

    @RequestMapping("del")
    public Map<String,Object> del(Integer id){
        return alleviationService.del(id);
    }

    @RequestMapping("list")
    public Map<String,Object> list(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        return alleviationService.list(pageNo,pageSize);
    }

    @RequestMapping("click")
    public Map<String,Object> click(Integer id, Date clicktime){
        return alleviationService.click(id,clicktime);
    }
}
