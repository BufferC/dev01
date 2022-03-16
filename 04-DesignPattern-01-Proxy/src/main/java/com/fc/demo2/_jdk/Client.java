package com.fc.demo2._jdk;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    @Test
    public void test() {
        GamePlayer player = new GamePlayer();

        // 对真实对象进行增强
        InvocationHandler gameOffice = new GameOffice(player);

        // 获取代理对象
        GamePlay proxy = (GamePlay) Proxy.newProxyInstance(player.getClass().getClassLoader(),
                player.getClass().getInterfaces(), gameOffice);

        proxy.login();
        proxy.killBoss();
        proxy.upgrade();
    }
}
