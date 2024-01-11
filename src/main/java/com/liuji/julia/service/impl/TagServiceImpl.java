package com.liuji.julia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuji.julia.dao.TagDao;
import com.liuji.julia.entity.Tag;
import com.liuji.julia.service.TagService;
import org.springframework.stereotype.Service;

/**
 * (Tag)表服务实现类
 *
 * @author liuji
 * @since 2024-01-11 14:40:53
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagDao, Tag> implements TagService {

}

