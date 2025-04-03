package com.lzw.julia.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统用户角色表(SysUserRole)表实体类
 *
 * @author liuji
 * @since 2025-03-29 16:44:43
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("ums_sys_user_role")
public class SysUserRole {
    // 主键id
    @TableId(type = IdType.AUTO)
    private Integer id;

    // 用户id
    private Integer userId;

    // 角色id
    private Integer roleId;

}
