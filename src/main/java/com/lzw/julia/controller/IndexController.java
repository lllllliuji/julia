package com.lzw.julia.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Tag(name = "Index")
public class IndexController {
    @RequestMapping("/index")
    @Operation(summary = "获取主页")
    public String index() {
        return "index";
    }

    @GetMapping("/login_page")
    public String login() {
        return "login";
    }
}
