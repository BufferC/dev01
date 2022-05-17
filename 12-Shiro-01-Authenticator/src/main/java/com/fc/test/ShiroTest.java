package com.fc.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class ShiroTest {
    @Test
    public void test() {
        // 加载ini配置文件从而获取工厂对象
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        // 获取安全管理器
        SecurityManager securityManager = factory.getInstance();

        // 给工具类设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);

        // 获取主体
        Subject subject = SecurityUtils.getSubject();

        // 创建一个token
        UsernamePasswordToken token = new UsernamePasswordToken("rose", "123456");

        // 登录
        subject.login(token);

        // 判断是否认证成功
        boolean authenticated = subject.isAuthenticated();

        System.out.println("是否认证成功：" + authenticated);
    }
}
