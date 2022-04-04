package com.fc.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.util.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");

        Map<String, Object> map = new HashMap<>();

        if (token == null) {
            map.put("message", "token不存在");
        }

        try {
            // 解析token并且获取载荷
            Map<String, Object> claim = JwtUtil.getClaim(token);

            // 传递给控制器
            request.setAttribute("claim", claim);

            // 放行
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

        map.put("code", -1);
        map.put("success", false);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(map);

        response.setContentType("application/json; charset=UTF-8");

        response.getWriter().write(json);

        return false;
    }
}
