package com.fc.controller;

import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private MessageBoardService messageBoardService;

    @RequestMapping("add")
    public Map<String,Object> add(MessageBoardWithBLOBs messageBoard){
        return messageBoardService.add(messageBoard);
    }

    @RequestMapping("del")
    public Map<String,Object> del(String id){
        long userId = Long.parseLong(id);
        return messageBoardService.del(userId);
    }

    @RequestMapping("list")
    public Map<String,Object> list(@RequestParam(value = "pageNo",defaultValue = "1") String pageNo, @RequestParam(value = "pageSize",defaultValue = "5") String pageSize, @RequestParam(value = "id" ,required = false) String userid){
        Integer no = Integer.valueOf(pageNo);
        Integer size = Integer.valueOf(pageSize);
        long id;
        if (userid == null || userid.equals("")){
            id = -1;
        }else {
            id = Long.parseLong(userid);
        }
        return messageBoardService.list(no,size,id);
    }

    @RequestMapping("reply")
    public Map<String,Object> reply(@RequestParam(value = "id") Integer id,@RequestParam(value = "reply",required = false) String reply,@RequestParam(value = "rpicture",required = false) String rpicture,@RequestParam(value = "isdel",required = false) String isdel){
        return messageBoardService.reply(id,reply,rpicture,isdel);
    }
}
