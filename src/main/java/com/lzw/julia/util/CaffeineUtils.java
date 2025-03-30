package com.lzw.julia.util;

import com.github.benmanes.caffeine.cache.Cache;
import com.lzw.julia.security.JuliaUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CaffeineUtils {
    public static final String SYS_PREFIX = "SYS_";

    @Autowired
    private Cache<String, Object> caffeineCache;

    public JuliaUserDetails getJuliaUserDetails(String uuid) {
        return ((JuliaUserDetails) caffeineCache.getIfPresent(SYS_PREFIX + uuid));
    }

    public void setUserDetails(String uuid, Object userDetails) {
        caffeineCache.put(SYS_PREFIX + uuid, userDetails);
    }


}
