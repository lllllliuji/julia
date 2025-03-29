package com.lzw.julia.controller;

import com.lzw.julia.api.Result;
import com.lzw.julia.api.dto.LoginResultDto;
import com.lzw.julia.api.query.LoginQuery;
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
    public Result<LoginResultDto> login(@Validated @RequestBody LoginQuery query, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.error(bindingResult.getFieldErrors().getFirst().getDefaultMessage());
        }
        LoginResultDto loginResultDto = sysUserService.doLogin(query.getUsername(), query.getPassword());
        return Result.ok("登录成功", loginResultDto);
    }
}
