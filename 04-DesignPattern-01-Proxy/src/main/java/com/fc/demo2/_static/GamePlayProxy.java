package com.fc.demo2._static;

// 代理对象
public class GamePlayProxy implements GamePlay {
    private GamePlay gamePlayer;

    public GamePlayProxy(GamePlay gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void login() {
        gamePlayer.login();
    }

    @Override
    public void killBoss() {
        gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        gamePlayer.upgrade();

        this.luckDraw();
    }

    private void luckDraw() {
        System.out.println("很幸运，抽到了一个铭文碎片");
    }
}
