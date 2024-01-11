package com.liuji.julia.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * (Category)表实体类
 *
 * @author liuji
 * @since 2024-01-11 14:40:22
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_category")
public class Category {
    @TableId
    private Integer id;

    // 分类名
    private String categoryName;
    
    // 创建时间
    private Date createTime;
    
    // 更新时间
    private Date updateTime;
    
}
