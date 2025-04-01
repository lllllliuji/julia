package com.lzw.julia.security;

import com.lzw.julia.util.CaffeineUtils;
import com.lzw.julia.util.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Builder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Builder
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    public static final String AUTH_HEADER = "Authorization";

    private CaffeineUtils caffeineUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("JwtAuthenticationFilter!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        // 1.获取token，如果没token，直接放行
        String token = request.getHeader(AUTH_HEADER);
        if (token == null) {
            doFilter(request, response, filterChain);
            return;
        }
        // 2.有token，通过jwt工具类，解析用户信息
        String credential = JwtUtils.parseToken(token);
        if (credential == null) {
            doFilter(request, response, filterChain);
            return;
        }
        JuliaUserDetails juliaUserDetails = caffeineUtils.getJuliaUserDetails(credential);
        // 3. 用户信息缓存不存在或者过期了
        if (juliaUserDetails == null) {
            doFilter(request, response, filterChain);
            return;
        }
        // 4. 将用户信息放到SecurityContext中
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(juliaUserDetails, null, juliaUserDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 5. 执行剩下的过滤器
        doFilter(request, response, filterChain);
    }
}
