package com.fc.controller;

import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("poor")
public class PoorController {
    @Autowired
    private PoorService poorService;
    
    @RequestMapping("add")
    public ResultVo add(@RequestBody PoorWithBLOBs poor){
        return poorService.add(poor);
    }

    @RequestMapping("delete")
    public ResultVo del(Long id){
        return poorService.del(id);
    }

    @RequestMapping("update")
    public ResultVo update(@RequestBody PoorWithBLOBs poor){
        return poorService.update(poor);
    }

    @RequestMapping("getlist")
    public ResultVo list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,@RequestParam(value = "member",required = false)String member){
        return poorService.list(pageNum,pageSize,member);
    }

    @RequestMapping("click")
    public ResultVo click(PoorWithBLOBs poor){
        return poorService.click(poor.getId(),poor.getLastClickTime());
    }
}
