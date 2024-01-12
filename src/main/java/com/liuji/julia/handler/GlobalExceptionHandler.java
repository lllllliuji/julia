package com.liuji.julia.handler;

import com.liuji.julia.api.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 参数校验异常
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handleArgumentValidateException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errorMap = bindingResult.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, fieldError -> fieldError.getDefaultMessage() == null ? "" : fieldError.getDefaultMessage()));
        return Result.error(HttpStatus.BAD_REQUEST).errDetail(errorMap);
    }

    // 方法不支持
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public Result handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return Result.error(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(value = Throwable.class)
    public Result handleException(Throwable t) {
        log.error("exception type {} msg {}", t.getClass() ,t.getMessage());
        return Result.error();
    }
}