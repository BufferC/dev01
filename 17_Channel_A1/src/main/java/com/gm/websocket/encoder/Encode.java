package com.gm.websocket.encoder;

import com.alibaba.fastjson.JSON;
import com.gm.websocket.pojo.UserPojo;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * 自定义编码器
 * java对象转json
 */
public class Encode implements Encoder.Text<UserPojo>{
    @Override
    public String encode(UserPojo userPojo) throws EncodeException {
        return JSON.toJSONString(userPojo);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
