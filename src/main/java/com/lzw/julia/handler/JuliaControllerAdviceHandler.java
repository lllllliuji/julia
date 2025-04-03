package com.lzw.julia.handler;


import com.lzw.julia.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 只能捕获进入controller之后的异常，对于权限认证等未进入controller的异常无法捕获
 */
@Slf4j
@ControllerAdvice
public class JuliaControllerAdviceHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<?> errorHandler(Exception e) {
        return Result.error("系统错误");
    }

}
