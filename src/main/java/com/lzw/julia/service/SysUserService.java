package com.lzw.julia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzw.julia.entity.SysUser;
import com.lzw.julia.model.vo.UserVo;

/**
 * 系统用户表(SysUser)表服务接口
 *
 * @author liuji
 * @since 2025-03-29 16:44:25
 */
public interface SysUserService extends IService<SysUser> {
    UserVo doLogin(String username, String password);
}

