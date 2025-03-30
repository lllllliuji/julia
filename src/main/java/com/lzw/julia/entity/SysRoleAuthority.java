package com.lzw.julia.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 系统角色权限表(SysRoleAuthority)表实体类
 *
 * @author liuji
 * @since 2025-03-29 16:44:16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("ums_sys_role_authority")
public class SysRoleAuthority {
    // 主键id
    @TableId(type = IdType.AUTO)
    private Integer id;

    // 角色id
    private Integer roleId;
    
    // 权限id
    private Integer authorityId;
    
}
