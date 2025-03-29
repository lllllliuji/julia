package com.lzw.julia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzw.julia.dao.SysUserRoleDao;
import com.lzw.julia.entity.SysUserRole;
import com.lzw.julia.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 系统用户角色表(SysUserRole)表服务实现类
 *
 * @author liuji
 * @since 2025-03-29 16:44:43
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRole> implements SysUserRoleService {

}

