package com.lzw.julia.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzw.julia.entity.SysAuthority;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统权限表(SysAuthority)表数据库访问层
 *
 * @author liuji
 * @since 2025-03-29 16:41:18
 */
@Mapper
public interface SysAuthorityDao extends BaseMapper<SysAuthority> {

}

