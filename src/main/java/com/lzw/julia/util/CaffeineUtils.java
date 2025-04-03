package com.lzw.julia.util;

import com.github.benmanes.caffeine.cache.Cache;
import com.lzw.julia.security.JuliaUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CaffeineUtils {
    public static final String SYS_USER_PREFIX = "SYS_USER_";

    public static final String SYS_RESOURCE_AUTH_PREFIX = "SYS_RESOURCE_ROLE_";

    @Autowired
    private Cache<String, Object> caffeineCache;

    public JuliaUserDetails getJuliaUserDetails(String credential) {
        return ((JuliaUserDetails) caffeineCache.getIfPresent(SYS_USER_PREFIX + credential));
    }

    public void setUserDetails(String credential, Object userDetails) {
        caffeineCache.put(SYS_USER_PREFIX + credential, userDetails);
    }

    public String getRoleByResource(String resource) {
        Object ifPresent = caffeineCache.getIfPresent(SYS_RESOURCE_AUTH_PREFIX + resource);
        if (ifPresent != null) {
            return (String) ifPresent;
        }
        return null;
    }

    public void setResource2Role(String resource, String authority) {
        caffeineCache.put(SYS_RESOURCE_AUTH_PREFIX + resource, authority);
    }

}
