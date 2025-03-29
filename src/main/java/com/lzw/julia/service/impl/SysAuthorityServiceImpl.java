package com.lzw.julia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzw.julia.dao.SysAuthorityDao;
import com.lzw.julia.entity.SysAuthority;
import com.lzw.julia.service.SysAuthorityService;
import org.springframework.stereotype.Service;

/**
 * 系统权限表(SysAuthority)表服务实现类
 *
 * @author liuji
 * @since 2025-03-29 16:41:22
 */
@Service("sysAuthorityService")
public class SysAuthorityServiceImpl extends ServiceImpl<SysAuthorityDao, SysAuthority> implements SysAuthorityService {

}

