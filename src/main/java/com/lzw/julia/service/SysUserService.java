package com.lzw.julia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzw.julia.api.Result;
import com.lzw.julia.api.dto.LoginResultDto;
import com.lzw.julia.entity.SysUser;

/**
 * 系统用户表(SysUser)表服务接口
 *
 * @author liuji
 * @since 2025-03-29 16:44:25
 */
public interface SysUserService extends IService<SysUser> {
    LoginResultDto doLogin(String username, String password);
}

