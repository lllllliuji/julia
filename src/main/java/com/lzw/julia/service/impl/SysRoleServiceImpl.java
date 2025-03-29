package com.lzw.julia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzw.julia.dao.SysRoleDao;
import com.lzw.julia.entity.SysRole;
import com.lzw.julia.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * 系统角色表(SysRole)表服务实现类
 *
 * @author liuji
 * @since 2025-03-29 16:42:50
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

}

