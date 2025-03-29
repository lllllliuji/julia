package com.lzw.julia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzw.julia.dao.SysRoleAuthorityDao;
import com.lzw.julia.entity.SysRoleAuthority;
import com.lzw.julia.service.SysRoleAuthorityService;
import org.springframework.stereotype.Service;

/**
 * 系统角色权限表(SysRoleAuthority)表服务实现类
 *
 * @author liuji
 * @since 2025-03-29 16:44:16
 */
@Service("sysRoleAuthorityService")
public class SysRoleAuthorityServiceImpl extends ServiceImpl<SysRoleAuthorityDao, SysRoleAuthority> implements SysRoleAuthorityService {

}

