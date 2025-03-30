package com.lzw.julia.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserVo {
    // 用户账号
    private String username;

    // 用户性别（0男 1女 2未知）
    private Integer gender;

    // 头像地址
    private String avatar;

    // 登录凭证
    private String token;

}
