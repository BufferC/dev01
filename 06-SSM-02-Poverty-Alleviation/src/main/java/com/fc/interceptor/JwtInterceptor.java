package com.fc.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

// token验证拦截器
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("请求的路径：" + request.getRequestURI());

        // 从请求头中获取token
        String token = request.getHeader("Authorization");

       Map<String, Object> map = new HashMap<>();

       map.put("success", false);
       map.put("code", -1);

       if (token == null || token.equals("")) {
           map.put("message", "token不存在");
       } else {
           try {
               // 解析token
               DecodedJWT decode = JWT.decode(token);

               Claim saltClaim = decode.getClaim("salt");

               // 获取盐值
               String salt = saltClaim.asString();

               JWT.require(Algorithm.HMAC256(salt))
                       .build()
                       .verify(token);

               return true;
           } catch (AlgorithmMismatchException e) {
               map.put("message", "算法不匹配");
           } catch (InvalidClaimException e) {
               map.put("message", "非法载荷");
           } catch (SignatureVerificationException e) {
               map.put("message", "签名验证失败");
           } catch (TokenExpiredException e) {
               map.put("message", "token已过期");
           } catch (Exception e) {
               map.put("message", "token发生异常");
           }
       }

        response.setContentType("application/json;charset=UTF-8");

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(map);

        response.getWriter().write(json);

        return false;
    }
}
