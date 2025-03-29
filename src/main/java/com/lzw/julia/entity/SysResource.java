package com.lzw.julia.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 系统资源表(SysResource)表实体类
 *
 * @author liuji
 * @since 2025-03-29 16:42:28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("ums_sys_resource")
public class SysResource {
    // 主键
    @TableId
    private Integer id;

    // 资源名称
    private String resourceName;
    
    // 资源url
    private String url;
    
    // 创建者
    private String creator;
    
    // 更新者
    private String updater;
    
    // 创建时间
    private Date createTime;
    
    // 修改时间
    private Date updateTime;
    
}
