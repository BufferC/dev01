package com.fc.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    // 获取token
    public static String getToken(Map<String, Object> claim, String salt) {
        claim.put("exp", System.currentTimeMillis() + 1000 * 20);
        claim.put("iat", System.currentTimeMillis());

        // 未编码的头部
        String jsonHeader = "{\"alg\": \"HS256\"}";

        // 编码后的头部
        String header = Base64.getEncoder().encodeToString(jsonHeader.getBytes(StandardCharsets.UTF_8));

        ObjectMapper objectMapper = new ObjectMapper();

        // 未编码的载荷
        String jsonPayload = null;

        try {
            jsonPayload = objectMapper.writeValueAsString(claim);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // 编码后的载荷
        String payload = Base64.getEncoder().encodeToString(jsonPayload.getBytes(StandardCharsets.UTF_8));

        // 获取十六进制md5加密后的签名
        String signature = DigestUtils.md5Hex(header + "." + payload + salt);

        StringBuilder builder = new StringBuilder();

        builder.append(header)
                .append(".")
                .append(payload)
                .append(".")
                .append(signature);

        return new String(builder);
    }

    // 验证token
    public static Map<String, Object> verify(String token, String salt) {

        Map<String, Object> result = new HashMap<>();

        String[] array = token.split("\\.");

        String payload = array[1];

        // 对载荷进行解码
        byte[] jsonPayload = Base64.getDecoder().decode(payload.getBytes(StandardCharsets.UTF_8));

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> claim = null;

        try {
            claim = objectMapper.readValue(jsonPayload, new TypeReference<Map<String, Object>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取失效时间
        Long exp = (Long) claim.get("exp");

        // 如果当前时间已经超过了过期时间
        if (System.currentTimeMillis() >= exp) {
            result.put("message", "token已经失效");
            result.put("code", -1);
            result.put("success", false);

            return result;
        }

        // 获取新的签名
        String sign = DigestUtils.md5Hex(array[0] + "." + array[1] + salt);

        // 签名相同说明token没问题
        if (sign.equals(array[2])) {
            result.put("message", "token没问题");
            result.put("code", 200);
            result.put("success", true);
            result.put("data", claim);
            return result;
        }

        result.put("message", "token无法验证");
        result.put("code", -1);
        result.put("success", false);

        return result;
    }
}
