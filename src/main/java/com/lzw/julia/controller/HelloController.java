package com.lzw.julia.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
@Tag(name = "Hello")
public class HelloController {
    @GetMapping
    @Operation(summary = "打招呼")
    public String hello() {
        return "hello";
    }
}
