package com.fc.controller;

import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("msgboard")
public class CommentController {
    @Autowired
    private MessageBoardService messageBoardService;

    @RequestMapping("add")
    public ResultVo add(@RequestBody MessageBoardWithBLOBs messageBoard){
        return messageBoardService.add(messageBoard);
    }

    @RequestMapping("delete")
    public ResultVo del(Long id){
        return messageBoardService.del(id);
    }

    @RequestMapping("getlist")
    public ResultVo list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, @RequestParam(value = "username",required = false) String username){
        return messageBoardService.list(pageNum,pageSize,username);
    }

    @RequestMapping("update")
    public ResultVo reply(@RequestBody MessageBoardWithBLOBs messageBoardWithBLOBs/*,@RequestParam(value = "isDel",required = false) String isDel*/){
        return messageBoardService.reply(messageBoardWithBLOBs/*,isDel*/);
    }
}
