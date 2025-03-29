package com.lzw.julia.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzw.julia.entity.SysRoleAuthority;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统角色权限表(SysRoleAuthority)表数据库访问层
 *
 * @author liuji
 * @since 2025-03-29 16:44:16
 */
@Mapper
public interface SysRoleAuthorityDao extends BaseMapper<SysRoleAuthority> {

}

