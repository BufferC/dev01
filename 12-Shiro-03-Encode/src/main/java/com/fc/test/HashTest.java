package com.fc.test;

import com.fc.util.HashUtil;
import org.junit.Test;

import java.util.Map;

public class HashTest {
    @Test
    public void test() {
        Map<String, String> credential = HashUtil.getCredential("123456");

        String password = credential.get("password");
        String salt = credential.get("salt");

        System.out.println(password);
        System.out.println(salt);
    }

    @Test
    public void testLogin() {
        String username = "易烊千玺";
        String password = "123456";
    }
}
