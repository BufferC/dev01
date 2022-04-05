package com.fc.service.impl;

import com.fc.dao.MessageBoardMapper;
import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageBoardServiceImpl implements MessageBoardService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;

    @Override
    public Map<String, Object> add(MessageBoardWithBLOBs messageBoard) {
        int affection = messageBoardMapper.insertSelective(messageBoard);

        Map<String, Object> map = new HashMap<>();

        if (affection == 1){
            map.put("message","留言成功!");
            map.put("code",200);
            map.put("success",true);
            map.put("data",affection);
        }else {
            map.put("message","留言失败!");
            map.put("code",500);
            map.put("success",false);
            map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
        }

        return map;
    }

    @Override
    public Map<String, Object> del(long id) {
        int affection = messageBoardMapper.deleteByPrimaryKey(id);
        Map<String, Object> map = new HashMap<>();
        if (affection == 1){
            map.put("message","删除留言成功!");
            map.put("code",200);
            map.put("success",true);
            map.put("data",affection);
        }else {
            map.put("message","删除留言失败!");
            map.put("code",404);
            map.put("success",false);
            map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
        }

        return map;
    }

    @Override
    public Map<String, Object> list(Integer pageNo, Integer pageSize, long id) {
        Map<String, Object> map = new HashMap<>();

        //数据总数
        long l = messageBoardMapper.countByExample(null);

        Map<String, Object> maps = new HashMap<>();

        maps.put( "total", l);

        if (id == -1){
            PageHelper.startPage(pageNo, pageSize);
            List<MessageBoardWithBLOBs> page = messageBoardMapper.selectByExampleWithBLOBs(null);
            maps.put("list",page);
            if(!page.isEmpty()){
                map.put("message","获取成功!");
                map.put("code",200);
                map.put("success",true);
                map.put("data",maps);
            }else {
                map.put("message","获取失败!");
                map.put("code",404);
                map.put("success",false);
                map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
            }

        }else {
            MessageBoard messageBoard = messageBoardMapper.selectByPrimaryKey(id);
            maps.put("list",messageBoard);
            if(messageBoard != null){
                map.put("message","用户获取成功!");
                map.put("code",200);
                map.put("success",true);
                map.put("data",maps);
            }else {
                map.put("message","用户获取失败!");
                map.put("code",404);
                map.put("success",false);
                map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> reply(Integer id, String reply, String rpicture, String isdel) {
        long rid = id.longValue();
        Map<String, Object> map = new HashMap<>();
        //删除回复
        int delReply = -86;
        //修改回复
        int upReply = -13;
        //修改图片
        int rPicture = -14;

        //不删除
        if (isdel == null || isdel.equals("false")||isdel.equals("")){

        }else if(reply == null){//删除
            delReply = messageBoardMapper.upReply(null, rid);
        }
        if (reply != null){
            upReply = messageBoardMapper.upReply(reply, rid);
        }

        if (rpicture != null){
            rPicture = messageBoardMapper.rPicture(rpicture, rid);
        }

        if (delReply != -86 || upReply != -13 || rPicture != -14){
            map.put("message","回复成功!");
            map.put("code",200);
            map.put("success",true);
            map.put("data",1);
        }else {
            map.put("message","回复失败!");
            map.put("code",404);
            map.put("success",false);
            map.put("data",new HashMap<String,Object>().put("errMsg","错误描述"));
        }
        return map;
    }
}
