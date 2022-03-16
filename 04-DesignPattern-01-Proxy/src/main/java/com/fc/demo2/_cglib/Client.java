package com.fc.demo2._cglib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

public class Client {
    @Test
    public void test() {
        GamePlayer gamePlayer = new GamePlayer();

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(GamePlayer.class);

        enhancer.setCallback(new GameOffice());

        GamePlayer proxy = (GamePlayer) enhancer.create();

        proxy.login();
        proxy.killBoss();
        proxy.upgrade();
    }
}
