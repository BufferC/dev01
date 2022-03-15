package com.fc.demo2._static;

// 被代理对象
public class GamePlayer implements GamePlay {
    @Override
    public void login() {
        System.out.println("爷傲奈我何 TiMi~");
    }

    @Override
    public void killBoss() {
        System.out.println("爷傲奈我何 打怪");
    }

    @Override
    public void upgrade() {
        System.out.println("爷傲奈我何 升级");
    }
}
