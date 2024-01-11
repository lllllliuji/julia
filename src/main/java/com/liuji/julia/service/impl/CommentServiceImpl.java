package com.liuji.julia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuji.julia.dao.CommentDao;
import com.liuji.julia.entity.Comment;
import com.liuji.julia.service.CommentService;
import org.springframework.stereotype.Service;

/**
 * (Comment)表服务实现类
 *
 * @author liuji
 * @since 2024-01-11 14:40:37
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentDao, Comment> implements CommentService {

}

