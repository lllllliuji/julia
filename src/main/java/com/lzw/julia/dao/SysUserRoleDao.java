package com.lzw.julia.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzw.julia.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户角色表(SysUserRole)表数据库访问层
 *
 * @author liuji
 * @since 2025-03-29 16:44:43
 */
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRole> {

}

