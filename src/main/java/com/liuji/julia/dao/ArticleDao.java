package com.liuji.julia.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuji.julia.entity.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Article)表数据库访问层
 *
 * @author liuji
 * @since 2024-01-11 14:46:11
 */
@Mapper
public interface ArticleDao extends BaseMapper<Article> {

}

