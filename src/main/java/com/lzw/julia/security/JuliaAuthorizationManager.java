package com.lzw.julia.security;

import com.lzw.julia.util.CaffeineUtils;
import com.lzw.julia.util.SecurityUtils;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;

import java.util.List;
import java.util.function.Supplier;

/**
 * 判断一个Authentication是否有权限访问某个对象.
 */
@Slf4j
@Builder
public class JuliaAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

    public static final String ADMIN = "Admin";

    private CaffeineUtils caffeineUtils;

    @Override
    public void verify(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
        AuthorizationManager.super.verify(authentication, object);
    }

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authenticationSupplier, RequestAuthorizationContext object) {
        try {
            String resource = object.getRequest().getRequestURI();
            String role = caffeineUtils.getRoleByResource(resource);

            List<String> userRoles = SecurityUtils.getUserRoles();
            log.info("checking for uri {}", resource);
            // 如果用户具有resource所需的角色，或者用户是管理员
            if (userRoles.contains(role) || userRoles.contains(ADMIN)) {
                return new AuthorizationDecision(true);
            }
        } catch (Exception e) {
            return new AuthorizationDecision(false);
        }
        return new AuthorizationDecision(false);
    }
}
