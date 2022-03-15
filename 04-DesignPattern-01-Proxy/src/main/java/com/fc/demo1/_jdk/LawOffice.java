package com.fc.demo1._jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 律师事务所，可以生成代理律师
public class LawOffice implements InvocationHandler {
    // 真实的被代理对象
    private final Object target;

    public LawOffice(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("案情进展：" + method.getName());

        // 执行被代理对象的方法
        Object invoke = method.invoke(target, args);

        // 如果访问的是defend方法，就进行增强
        if (method.getName().equals("defend")) {
            System.out.println("交换意见");
        }

        return invoke;
    }
}
