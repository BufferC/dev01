package com.fc.service;

import com.fc.entity.MessageBoardWithBLOBs;

import java.util.Map;

public interface MessageBoardService {
    Map<String, Object> add(MessageBoardWithBLOBs messageBoard);

    Map<String, Object> del(long userId);

    Map<String, Object> list(Integer no, Integer size, long id);

    Map<String, Object> reply(Integer id, String reply, String rpicture, String isdel);
}
