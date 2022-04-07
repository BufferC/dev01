package com.fc.controller;


import com.fc.entity.Alleviation;
import com.fc.service.AlleviationService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("policy")
public class AlleviationController {
    @Autowired
    private AlleviationService alleviationService;

    @RequestMapping("add")
    public ResultVo add(@RequestBody Alleviation alleviation){
        return alleviationService.add(alleviation);
    }

    @RequestMapping("update")
    public ResultVo update(@RequestBody Alleviation alleviation){
        return alleviationService.update(alleviation);
    }

    @RequestMapping("del")
    public ResultVo del(Long id){
        return alleviationService.del(id);
    }

    @RequestMapping("list")
    public ResultVo list(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        return alleviationService.list(pageNo,pageSize);
    }

    @RequestMapping("click")
    public ResultVo click(Alleviation alleviation){
        return alleviationService.click(alleviation.getId(),alleviation.getLastClickTime());
    }
}
