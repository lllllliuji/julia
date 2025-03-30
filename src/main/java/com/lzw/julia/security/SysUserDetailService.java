package com.lzw.julia.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lzw.julia.dao.SysUserDao;
import com.lzw.julia.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserDetailService implements UserDetailsService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1.查询用户信息
        LambdaQueryWrapper<SysUser> sysUserWrapper = new LambdaQueryWrapper<>();
        sysUserWrapper.eq(SysUser::getUsername, username);
        SysUser sysUser = sysUserDao.selectOne(sysUserWrapper);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 2.查询用户的权限信息
        List<String> userAuthorities = sysUserDao.getAuthoritiesByUserId(sysUser.getId());

        return JuliaUserDetails.builder()
                .sysUser(sysUser)
                .userAuthorities(userAuthorities)
                .build();
    }
}
