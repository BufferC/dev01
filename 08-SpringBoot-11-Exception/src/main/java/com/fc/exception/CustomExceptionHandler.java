package com.fc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(SingletonDogException.class)
    // 指定响应的状态码
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> handleCustom(Exception e) {
        Map<String, Object> map = new HashMap<>();

        map.put("code", -5000);
        map.put("message", "发生了单身狗异常");
        map.put("success", false);
        map.put("data", e.getMessage());

        return map;
    }

    @ExceptionHandler(Exception.class)
    // 指定响应的状态码
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleSystem(Exception e) {
        System.out.println("系统异常处理~~~");

        Map<String, Object> map = new HashMap<>();

        map.put("code", -4000);
        map.put("message", "发生了系统异常");
        map.put("success", false);
        map.put("data", e.getMessage());

        return map;
    }
}
