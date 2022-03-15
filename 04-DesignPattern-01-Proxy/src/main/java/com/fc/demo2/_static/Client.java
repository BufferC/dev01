package com.fc.demo2._static;

import org.junit.Test;

public class Client {
    @Test
    public void test() {
        GamePlay player = new GamePlayer();

        GamePlay proxy = new GamePlayProxy(player);

        proxy.login();
        proxy.killBoss();
        proxy.upgrade();
    }
}
