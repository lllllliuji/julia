package com.lzw.julia.util;

import com.lzw.julia.security.JuliaUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

public class SecurityUtils {
    /**
     * 获取  Authentication
     * @return 认证信息
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static List<String> getUserRoles() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return List.of();
        }
        return ((JuliaUserDetails) authentication.getPrincipal()).getUserRoles();
//        return authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
    }

}
