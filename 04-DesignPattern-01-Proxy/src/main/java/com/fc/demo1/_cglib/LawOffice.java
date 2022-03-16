package com.fc.demo1._cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LawOffice implements MethodInterceptor {
    @Override
    public Object intercept(Object parent, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (method.getName().equals("submit")) {
            System.out.println("搜集证据");
        }

        // 让代理对象执行真实对象中的方法
        Object o = proxy.invokeSuper(parent, args);

        if (method.getName().equals("defend")) {
            System.out.println("交换意见");
        }
        return o;
    }
}
