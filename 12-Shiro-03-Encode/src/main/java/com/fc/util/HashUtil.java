package com.fc.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.HashMap;
import java.util.Map;

/**
 * 散列工具类，用来对密码进行加密
 */
public class HashUtil {
    // 加密方式
    public static final String ALGORITHM_NAME = "SHA-1";
    // 散列次数
    public static final Integer HASH_ITERATIONS = 512;

    /**
     * 散列算法
     * @param src 源字符串
     * @param salt 盐
     * @return 散列后的字符串
     */
    public static String hash(String src, String salt) {
        // 使用给定的盐创建特定源的算法的特定的加密值，总共散列指定的次数次
        return new SimpleHash(ALGORITHM_NAME, src, salt, HASH_ITERATIONS).toString();
    }

    /**
     * 获取盐
     * @return 盐
     */
    public static String generateSalt() {
        // 获取随机数生成器
        SecureRandomNumberGenerator generator = new SecureRandomNumberGenerator();
        // 获取 Base 64 格式字符串表示形式的盐值
        return generator.nextBytes().toBase64();
    }

    /**
     * 获取凭证信息
     * @param password 源密码
     * @return 包含凭证信息的Map集合
     */
    public static Map<String, String> getCredential(String password) {
        // 获取盐值
        String salt = generateSalt();

        // 真正的密码和盐值重新生成一个加密后的密码
        String dest = hash(password, salt);

        Map<String, String> map = new HashMap<>();

        map.put("password", dest);
        map.put("salt", salt);

        return map;
    }
}