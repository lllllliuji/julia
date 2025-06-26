package com.lzw.julia.handler;


import com.lzw.julia.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 只能捕获进入controller之后的异常，对于权限认证等未进入controller的异常无法捕获
 */
@Slf4j
@RestControllerAdvice
public class JuliaControllerAdviceHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<?> errorHandler(Exception e) {
        return Result.error("系统错误");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<?> error(MethodArgumentNotValidException e) {
        return Result.error(HttpStatus.BAD_REQUEST.value(), e.getBindingResult().getAllErrors().getFirst().getDefaultMessage());
    }

}
