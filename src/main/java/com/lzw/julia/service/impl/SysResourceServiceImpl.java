package com.lzw.julia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzw.julia.dao.SysResourceDao;
import com.lzw.julia.entity.SysResource;
import com.lzw.julia.service.SysResourceService;
import org.springframework.stereotype.Service;

/**
 * 系统资源表(SysResource)表服务实现类
 *
 * @author liuji
 * @since 2025-03-29 16:42:28
 */
@Service("sysResourceService")
public class SysResourceServiceImpl extends ServiceImpl<SysResourceDao, SysResource> implements SysResourceService {

}

