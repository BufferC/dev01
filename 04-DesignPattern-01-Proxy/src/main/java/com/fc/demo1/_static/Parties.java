package com.fc.demo1._static;

// 当事人，原告(被代理对象，真实对象)
public class Parties implements Lawsuit {
    @Override
    public void submit() {
        System.out.println("老板欠薪带着小姨子跑路了...");
    }

    @Override
    public void defend() {
        System.out.println("还我血汗钱！！！");
    }
}
