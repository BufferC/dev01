package com.fc.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private static final String ALG = "HS256";
    private static final String TYP = "JWT";
    private static final Algorithm ALGORITHM;
    private static final Map<String, Object> HEADER = new HashMap<>();
    private static final String SALT = "ertyuoimn";

    static {
        HEADER.put("alg", ALG);
        HEADER.put("typ", TYP);
        ALGORITHM = Algorithm.HMAC256(SALT);
    }

    // 创建token
    public static String createToken(Map<String, Object> claim, Long exp) {
        return JWT.create()
                .withHeader(HEADER)
                .withClaim("claim", claim)
                .withExpiresAt(new Date(exp))
                .sign(ALGORITHM);
    }

    // 解析token
    public static DecodedJWT parseToken(String token) {
        return JWT.require(ALGORITHM).build().verify(token);
    }

    // 获取载荷
    public static Map<String, Object> getClaim(String token) {
        return parseToken(token).getClaim("claim").asMap();
    }
}
