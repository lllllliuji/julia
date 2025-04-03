package com.lzw.julia.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统资源角色表(SysResourceRole)表实体类
 *
 * @author liuji
 * @since 2025-04-03 16:28:56
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("ums_sys_resource_role")
public class SysResourceRole {
    //主键id
    @TableId(type = IdType.AUTO)
    private Integer id;

    // 资源id
    private Integer resourceId;

    // 角色id
    private Integer roleId;

}
