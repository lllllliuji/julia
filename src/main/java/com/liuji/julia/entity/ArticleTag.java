package com.liuji.julia.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * (ArticleTag)表实体类
 *
 * @author liuji
 * @since 2024-01-11 14:39:56
 */
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_article_tag")
public class ArticleTag {
    @TableId
    private Integer id;

    // 文章id
    private Integer articleId;
    
    // 标签id
    private Integer tagId;
    
}
