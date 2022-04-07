package com.fc.controller;

import com.fc.entity.Alleviation;
import com.fc.service.AlleviationService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alleviation")
public class AlleviationController {
    @Autowired
    private AlleviationService alleviationService;

    @PostMapping("click")
    public ResultVO click(Alleviation alleviation) {
        return alleviationService.click(alleviation.getId(), alleviation.getLastClickTime());
    }

    @GetMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize,
                            Long id) {
        return alleviationService.getList(pageNum, pageSize, id);
    }

    @PostMapping("add")
    public ResultVO add(@RequestBody Alleviation alleviation) {
        return alleviationService.add(alleviation);
    }

    @PostMapping("update")
    public ResultVO update(@RequestBody Alleviation alleviation) {
        return alleviationService.update(alleviation);
    }

    @GetMapping("delete")
    public ResultVO delete(Long id) {
        return alleviationService.delete(id);
    }

}
