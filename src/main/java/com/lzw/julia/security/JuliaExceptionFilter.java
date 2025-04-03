package com.lzw.julia.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JuliaExceptionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (NullPointerException e) {
            // 记录日志，方便排查
            e.printStackTrace();

            // 直接返回 500 错误，不跳转 /error
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "系统异常：" + e.getMessage());
        } catch (Exception e) {
            // 其他异常也可以在这里处理
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "未知错误：" + e.getMessage());
        }
    }
}
