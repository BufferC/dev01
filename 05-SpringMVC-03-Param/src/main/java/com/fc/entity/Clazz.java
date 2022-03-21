package com.fc.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Clazz {
    private List<UserInfo> list;
    private Map<String, User> map;
}
