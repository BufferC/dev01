package com.fc.controller;


import com.fc.entity.Alleviation;
import com.fc.entity.AlleviationWithBLOBs;
import com.fc.service.AlleviationService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("alleviation")
public class AlleviationController {
    @Autowired
    private AlleviationService alleviationService;

    @RequestMapping("add")
    public ResultVo add(@RequestBody AlleviationWithBLOBs alleviation){
        return alleviationService.add(alleviation);
    }

    @RequestMapping("update")
    public ResultVo update(@RequestBody AlleviationWithBLOBs alleviation){
        System.out.println(alleviation.getContent()+"**************************");
        return alleviationService.update(alleviation);
    }

    @RequestMapping("delete")
    public ResultVo del(Long id){
        return alleviationService.del(id);
    }

    @RequestMapping("getlist")
    public ResultVo list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,@RequestParam(value = "type",required = false) String type){
        return alleviationService.list(pageNum,pageSize,type);
    }

    @RequestMapping("click")
    public ResultVo click(Alleviation alleviation){
        return alleviationService.click(alleviation.getId(),alleviation.getLastClickTime());
    }
}
