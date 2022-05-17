package com.fc.test;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.junit.Test;

public class EncodingTest {
    // 十六进制编码
    @Test
    public void testHexEncoding() {
        String src = "易烊千玺";

        String desc = Hex.encodeToString(src.getBytes());

        System.out.println(desc);
    }

    // 十六进制解码
    @Test
    public void testHexDecoding() {
        String src = "e69893e7838ae58d83e78eba";

        String desc = new String(Hex.decode(src.getBytes()));

        System.out.println(desc);
    }

    // Base64编码
    @Test
    public void testBase64Encoding() {
        String src = "易烊千玺";

        String desc = Base64.encodeToString(src.getBytes());

        System.out.println(desc);
    }

    // Base64解码
    @Test
    public void testBase64Decoding() {
        String src = "5piT54OK5Y2D5466";

        String desc = new String(Base64.decode(src.getBytes()));

        System.out.println(desc);
    }
}
