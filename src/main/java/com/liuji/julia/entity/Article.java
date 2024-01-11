package com.liuji.julia.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Article)表实体类
 *
 * @author liuji
 * @since 2024-01-11 14:46:40
 */
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_article")
public class Article {
    @TableId
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
    
    // 是否删除  0否 1是
    private Integer deleted;
    
    // 状态值 1公开 2私密 3草稿
    private Integer status;
    
    // 创建时间
    private Date createTime;
    
    // 更新时间
    private Date updateTime;
    
}
