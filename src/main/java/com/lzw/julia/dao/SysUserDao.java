package com.lzw.julia.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzw.julia.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户表(SysUser)表数据库访问层
 *
 * @author liuji
 * @since 2025-03-29 16:44:25
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {

}

