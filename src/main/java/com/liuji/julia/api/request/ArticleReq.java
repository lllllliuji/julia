package com.liuji.julia.api.request;

import lombok.Data;

@Data
public class ArticleReq {
    private Integer id;

    // 作者
    private Integer authorId;

    // 文章分类
    private Integer categoryId;

    // 文章缩略图
    private String cover;

    // 标题
    private String title;

    // 文章摘要，如果该字段为空，默认取文章的前500个字符作为摘要
    private String contentAbstract;

    // 内容
    private String content;
}