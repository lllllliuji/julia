package com.lzw.julia.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 为了验证跳转到指定页面，不用restcontroller
@Tag(name = "火影忍者api")
@RequestMapping("/huoying")
public class HuoYingController {

    @GetMapping("/shou-li-jian")
    public String shoulijian() {
        return "shou-li-jian";
    }

    @GetMapping("/luo-xuan-wan")
    public String luoxuanwan() {
        return "luo-xuan-wan";
    }

    @GetMapping("/xian-ren")
    public String xianren() {
        return "xian-ren";
    }

    @GetMapping("/xie-lun-yan")
    public String xielunyan() {
        return "xie-lun-yan";
    }

    @GetMapping("/qian-niao")
    public String qianniao() {
        return "qian-niao";
    }

    @GetMapping("/shen-luo-tian-zheng")
    public String shenluotianzhen() {
        return "shen-luo-tian-zhen";
    }

    @PreAuthorize("hasAnyRole('RenZhuLi')")
    @GetMapping("/wei-shou-yu")
    public String weishouyu() {
        return "wei-shou-yu";
    }

}
