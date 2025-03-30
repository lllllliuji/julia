package com.lzw.julia.controller;

import com.lzw.julia.model.Result;
import com.lzw.julia.model.dto.LoginQuery;
import com.lzw.julia.model.vo.UserVo;
import com.lzw.julia.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/login")
    public Result<UserVo> login(@Validated @RequestBody LoginQuery query, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.error(
                    bindingResult
                            .getFieldErrors()
                            .getFirst()
                            .getDefaultMessage()
            );
        }
        UserVo userVo = sysUserService.doLogin(query.getUsername(), query.getPassword());
        if (userVo == null) {
            return Result.error("登录失败");
        }
        return Result.ok("登录成功", userVo);
    }
}
