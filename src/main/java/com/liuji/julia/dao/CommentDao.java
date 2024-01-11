package com.liuji.julia.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuji.julia.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Comment)表数据库访问层
 *
 * @author liuji
 * @since 2024-01-11 14:40:37
 */
@Mapper
public interface CommentDao extends BaseMapper<Comment> {

}

