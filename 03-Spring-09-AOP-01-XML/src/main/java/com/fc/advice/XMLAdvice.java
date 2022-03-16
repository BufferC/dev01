package com.fc.advice;

import org.aspectj.lang.ProceedingJoinPoint;

// 切面类，用于指定增强的方法
public class XMLAdvice {
    // 前置通知
    public void before() {
        System.out.println("前置通知，方法执行前执行~~~");
    }

    // 后置通知
    public void afterReturning() {
        System.out.println("后置通知，方法正常返回后执行~~~");
    }

    // 最终通知
    public void after() {
        System.out.println("最终通知，无论是否发生异常都会执行~~~");
    }

    // 异常通知
    public void afterThrowing() {
        System.out.println("异常通知，方法发生异常执行~~~");
    }

    // 环绕通知
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知--前置");

        // 执行被代理对象的方法
        Object proceed = joinPoint.proceed();

        System.out.println("环绕通知--后置");

        return proceed;
    }
}
