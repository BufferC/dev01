package com.fc.controller;

import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("poor")
public class PoorController {
    @Autowired
    private PoorService poorService;
    
    @RequestMapping("add")
    public ResultVo add(PoorWithBLOBs poor){
        return poorService.add(poor);
    }

    @RequestMapping("delete")
    public ResultVo del(Long id){
        return poorService.del(id);
    }

    @RequestMapping("update")
    public ResultVo update(PoorWithBLOBs poor){
        return poorService.update(poor);
    }

    @RequestMapping("list")
    public ResultVo list(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,Long id){
        return poorService.list(pageNo,pageSize,id);
    }

    @RequestMapping("click")
    public ResultVo click(PoorWithBLOBs poor){
        return poorService.click(poor.getId(),poor.getLastClickTime());
    }
}
