package com.liuji.julia.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuji.julia.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Category)表数据库访问层
 *
 * @author liuji
 * @since 2024-01-11 14:40:22
 */
@Mapper
public interface CategoryDao extends BaseMapper<Category> {

}

