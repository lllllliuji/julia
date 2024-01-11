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
 * (Comment)表实体类
 *
 * @author liuji
 * @since 2024-01-11 14:40:37
 */
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_comment")
public class Comment {
    //主键
    @TableId
    private Integer id;

    // 评论用户Id
    private Integer userId;
    
    // 评论内容
    private String commentContent;
    
    // 回复用户id
    private Integer replyUserId;
    
    // 父评论id
    private Integer parentId;
    
    // 评论类型 1.文章 2.其他
    private Integer type;
    
    // 是否删除  0否 1是
    private Integer deleted;
    
    // 创建时间
    private Date createTime;
    
    // 更新时间
    private Date updateTime;
    
}
