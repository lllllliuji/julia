package com.lzw.julia.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
@Tag(name = "Index")
public class IndexController {
    @GetMapping
    @Operation(summary = "获取主页")
    public String index() {
        return "index";
    }
}
