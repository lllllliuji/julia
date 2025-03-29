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
 * 系统用户表(SysUser)表实体类
 *
 * @author liuji
 * @since 2025-03-29 16:44:25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("ums_sys_user")
public class SysUser {
    // 用户ID
    @TableId
    private Integer id;

    // 用户账号
    private String username;
    
    // 用户昵称
    private String nickname;
    
    // 用户邮箱
    private String email;
    
    // 手机号码
    private String mobilePhone;
    
    // 用户性别（0男 1女 2未知）
    private Integer gender;
    
    // 头像地址
    private String avatar;
    
    // 密码
    private String password;
    
    // 帐号状态（0正常 1停用）
    private Integer status;
    
    // 创建者
    private String creator;
    
    // 创建时间
    private Date createTime;
    
    // 更新者
    private String updater;
    
    // 更新时间
    private Date updateTime;
    
    // 备注
    private String remark;
    
    private Integer deleted;
    
}
