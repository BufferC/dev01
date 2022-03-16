package com.fc.demo1._cglib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

public class Court {
    @Test
    public void test() {
        Parties parties = new Parties();

        Enhancer enhancer = new Enhancer();

        // 设置被代理对象
        enhancer.setSuperclass(parties.getClass());

        // 增强的逻辑
        enhancer.setCallback(new LawOffice());

        Parties proxy = (Parties) enhancer.create();

        proxy.submit();
        proxy.defend();
    }
}
