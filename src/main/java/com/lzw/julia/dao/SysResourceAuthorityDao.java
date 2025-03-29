package com.lzw.julia.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzw.julia.entity.SysResourceAuthority;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统资源权限表(SysResourceAuthority)表数据库访问层
 *
 * @author liuji
 * @since 2025-03-29 16:43:59
 */
@Mapper
public interface SysResourceAuthorityDao extends BaseMapper<SysResourceAuthority> {

}

