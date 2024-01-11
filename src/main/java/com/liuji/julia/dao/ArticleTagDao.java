package com.liuji.julia.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuji.julia.entity.ArticleTag;
import org.apache.ibatis.annotations.Mapper;

/**
 * (ArticleTag)表数据库访问层
 *
 * @author liuji
 * @since 2024-01-11 14:39:56
 */
@Mapper
public interface ArticleTagDao extends BaseMapper<ArticleTag> {

}

