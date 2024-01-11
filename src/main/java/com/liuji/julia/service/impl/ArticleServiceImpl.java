package com.liuji.julia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuji.julia.dao.ArticleDao;
import com.liuji.julia.entity.Article;
import com.liuji.julia.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * (Article)表服务实现类
 *
 * @author liuji
 * @since 2024-01-11 14:46:11
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements ArticleService {

}

