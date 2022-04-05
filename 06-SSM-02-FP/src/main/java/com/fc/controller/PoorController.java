package com.fc.controller;

import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("poor")
public class PoorController {
    @Autowired
    private PoorService poorService;
    
    @RequestMapping("add")
    public Map<String,Object> add(PoorWithBLOBs poor){
        return poorService.add(poor);
    }

    @RequestMapping("del")
    public Map<String,Object> del(Integer id){
        return poorService.del(id);
    }

    @RequestMapping("updata")
    public Map<String,Object> updata(Poor poor){
        return poorService.updata(poor);
    }

    @RequestMapping("list")
    public Map<String,Object> list(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,@RequestParam(value = "username" ,required = false) String username){
        return poorService.list(pageNo,pageSize,username);
    }

    @RequestMapping("click")
    public Map<String,Object> click(Integer id, Date clicktime){
        return poorService.click(id,clicktime);
    }
}
