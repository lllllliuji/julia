package com.liuji.julia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuji.julia.dao.ArticleTagDao;
import com.liuji.julia.entity.ArticleTag;
import com.liuji.julia.service.ArticleTagService;
import org.springframework.stereotype.Service;

/**
 * (ArticleTag)表服务实现类
 *
 * @author liuji
 * @since 2024-01-11 14:39:56
 */
@Service("articleTagService")
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagDao, ArticleTag> implements ArticleTagService {

}

