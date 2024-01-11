package com.liuji.julia.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuji.julia.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Tag)表数据库访问层
 *
 * @author liuji
 * @since 2024-01-11 14:40:53
 */
@Mapper
public interface TagDao extends BaseMapper<Tag> {

}

