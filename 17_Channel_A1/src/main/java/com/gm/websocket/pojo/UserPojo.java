package com.gm.websocket.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPojo implements Serializable {
    private String name;

    private String message;

    private String img;
}
