package com.fc.controller;

import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private MessageBoardService messageBoardService;

    @RequestMapping("add")
    public ResultVo add(MessageBoardWithBLOBs messageBoard){
        return messageBoardService.add(messageBoard);
    }

    @RequestMapping("delete")
    public ResultVo del(Long id){
        return messageBoardService.del(id);
    }

    @RequestMapping("list")
    public ResultVo list(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Long id){
        return messageBoardService.list(pageNo,pageSize,id);
    }

    @RequestMapping("reply")
    public ResultVo reply(MessageBoardWithBLOBs messageBoardWithBLOBs,@RequestParam(value = "isDel",required = false) String isDel){
        return messageBoardService.reply(messageBoardWithBLOBs,isDel);
    }
}
