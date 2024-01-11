package com.liuji.julia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuji.julia.dao.CategoryDao;
import com.liuji.julia.entity.Category;
import com.liuji.julia.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * (Category)表服务实现类
 *
 * @author liuji
 * @since 2024-01-11 14:40:22
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {

}

