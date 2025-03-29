package com.lzw.julia.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lzw.julia.dao.SysUserDao;
import com.lzw.julia.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
            throw new UsernameNotFoundException(username);
        }
        return JuliaUserDetails.builder().sysUser(sysUser).build();
    }
}
