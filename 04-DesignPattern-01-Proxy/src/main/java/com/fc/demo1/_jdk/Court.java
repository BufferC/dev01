package com.fc.demo1._jdk;

import com.fc.demo1._static.Lawsuit;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class Court {
    @Test
    public void test() {
        // 真实对象
        Lawsuit parties = new Parties();

        // 律师事务所
        LawOffice handler = new LawOffice(parties);

        // 获取代理对象
        Lawsuit proxy = (Lawsuit) Proxy.newProxyInstance(parties.getClass().getClassLoader(),
                parties.getClass().getInterfaces(),
                handler);

        proxy.submit();
        proxy.defend();
    }
}
