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
 * 系统角色表(SysRole)表实体类
 *
 * @author liuji
 * @since 2025-03-29 16:42:50
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("ums_sys_role")
public class SysRole {
    // 角色id
    @TableId(type = IdType.AUTO)
    private Integer id;

    // 角色名字
    private String roleName;

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
