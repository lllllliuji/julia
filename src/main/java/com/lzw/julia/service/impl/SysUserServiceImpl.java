package com.lzw.julia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.benmanes.caffeine.cache.Cache;
import com.lzw.julia.dao.SysUserDao;
import com.lzw.julia.entity.SysUser;
import com.lzw.julia.model.vo.UserVo;
import com.lzw.julia.security.JuliaUserDetails;
import com.lzw.julia.service.SysUserService;
import com.lzw.julia.util.CaffeineUtils;
import com.lzw.julia.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 系统用户表(SysUser)表服务实现类
 *
 * @author liuji
 * @since 2025-03-29 16:44:25
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CaffeineUtils caffeineUtils;

    @Override
    public UserVo doLogin(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = null;
        // 1.认证
        try {
            authentication = authenticationManager.authenticate(authenticationToken);
        } catch (Exception e) {
            return null;
        }
        // 2.生成token存入缓存，方便下次访问
        String credential = UUID.randomUUID().toString();
        String token = JwtUtils.createToken(credential);
        System.out.println(token);
        caffeineUtils.setUserDetails(credential, authentication.getPrincipal());
        // 3.返回数据
        SysUser sysUser = ((JuliaUserDetails) authentication.getPrincipal()).getSysUser();
        return UserVo.builder()
                .username(sysUser.getUsername())
                .avatar(sysUser.getAvatar())
                .gender(sysUser.getGender())
                .token(token)
                .build();
    }
}

