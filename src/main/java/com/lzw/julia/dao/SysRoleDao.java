package com.lzw.julia.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzw.julia.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统角色表(SysRole)表数据库访问层
 *
 * @author liuji
 * @since 2025-03-29 16:42:50
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRole> {

}

