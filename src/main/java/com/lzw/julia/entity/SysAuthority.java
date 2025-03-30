package com.lzw.julia.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 系统权限表(SysAuthority)表实体类
 *
 * @author liuji
 * @since 2025-03-29 16:41:21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("ums_sys_authority")
public class SysAuthority {
    // 权限id
    @TableId(type = IdType.AUTO)
    private Integer id;

    // 权限名字
    private String authorityName;

    // 备注
    private String remark;
    
    // 创建者
    private String creator;
    
    // 更新者
    private String updater;
    
    // 创建时间
    private Date createTime;
    
    // 修改时间
    private Date updateTime;
    
}
