package com.fc.advice;

import com.fc.vo.ResultVO;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// 对controller进行增强
@ControllerAdvice
public class GlobalExceptionHandler {
    // 对指定的异常进行捕获
    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    public ResultVO handleDuplicateKeyException(DuplicateKeyException e) {
        return new ResultVO(4000, "当前用户名已存在，不会用请联系系统管理员", false, e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultVO handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new ResultVO(5000, "请输入json格式的参数，不会用找管理员教教你", false, e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultVO handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return new ResultVO(6000, "缺少了必要的参数，不会用找管理员", false, e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultVO handleRuntimeException(RuntimeException e) {
        return new ResultVO(6000, "您的操作有误，请联系管理员", false, e.getMessage());
    }
}
