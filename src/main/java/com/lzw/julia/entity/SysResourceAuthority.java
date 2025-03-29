package com.lzw.julia.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 系统资源权限表(SysResourceAuthority)表实体类
 *
 * @author liuji
 * @since 2025-03-29 16:43:59
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("ums_sys_resource_authority")
public class SysResourceAuthority {
    // 主键id
    @TableId
    private Integer id;

    // 资源id
    private Integer resourceId;
    
    // 权限id
    private Integer authorityId;
    
}
