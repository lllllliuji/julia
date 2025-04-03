package com.lzw.julia.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzw.julia.entity.SysResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统资源表(SysResource)表数据库访问层
 *
 * @author liuji
 * @since 2025-03-29 16:42:28
 */
@Mapper
public interface SysResourceDao extends BaseMapper<SysResource> {
    List<String> getRolesByResourceName(String resourceName);
}

