package com.fc.util;

import org.jasypt.util.text.BasicTextEncryptor;

// 加密工具类
public class JasyptUtil {
    public static void main(String[] args) {
        String username = "root";
        String password = "root";
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        //秘钥
        // 设置盐值
        //encryptor.setPassword(System.getProperty("jasypt.encryptor.password"));
        encryptor.setPassword("qwertyui");
        //密码进行加密
        String newUsername = encryptor.encrypt(username);
        String newPassword = encryptor.encrypt(password);
        System.out.println("加密后账号：" + newUsername);
        System.out.println("加密后密码：" + newPassword);
    }
}