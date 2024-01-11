package com.liuji.julia.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * (Tag)表实体类
 *
 * @author liuji
 * @since 2024-01-11 14:40:53
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_tag")
public class Tag {
    @TableId
    private Integer id;

    // 标签名
    private String tagName;
    
    // 创建时间
    private Date createTime;
    
    // 更新时间
    private Date updateTime;
    
}
