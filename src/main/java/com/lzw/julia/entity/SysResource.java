package com.lzw.julia.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    @TableId(type = IdType.AUTO)
    private Integer id;

    // 资源名称
    private String resourceName;

    // 资源uri
    private String uri;

    // 创建者
    private String creator;

    // 更新者
    private String updater;

    // 创建时间
    private Date createTime;

    // 修改时间
    private Date updateTime;

}
