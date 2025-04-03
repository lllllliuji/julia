package com.lzw.julia.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzw.julia.entity.SysResourceRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统资源角色表(SysResourceRole)表数据库访问层
 *
 * @author liuji
 * @since 2025-04-03 16:28:56
 */
@Mapper
public interface SysResourceRoleDao extends BaseMapper<SysResourceRole> {

}

