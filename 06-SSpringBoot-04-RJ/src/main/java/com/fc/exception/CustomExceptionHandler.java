package com.fc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MyException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> sSystem(Exception e){
        Map<String, Object> map = new HashMap<>();

        map.put("code",-1);
        map.put("message","发生了系统异常");
        map.put("success",false);
        map.put("date",e.getMessage());
        return map;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,Object> pSystem(Exception e){
        Map<String, Object> map = new HashMap<>();

        map.put("code",-1);
        map.put("message","发生了系统异常");
        map.put("success",false);
        map.put("data",e.getMessage());
        return map;
    }

    /*@ExceptionHandler(SexException.class)
    // 指定响应的状态码
    @ResponseStatus(HttpStatus.OK)
    public Map<String,Object> handleCustom(Exception e){
        Map<String, Object> map = new HashMap<>();

        map.put("code",-2);
        map.put("message","发生了单身异常");
        map.put("success",false);
        map.put("date",e.getMessage());
        return map;
    }*/
}
