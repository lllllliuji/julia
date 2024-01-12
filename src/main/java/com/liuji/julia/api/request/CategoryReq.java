package com.liuji.julia.api.request;

import lombok.Data;

@Data
public class CategoryReq {

    private Integer id;

    // 分类名
    private String categoryName;
}
