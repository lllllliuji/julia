package com.liuji.julia.api.request;

import com.liuji.julia.validator.CreateGroup;
import com.liuji.julia.validator.DeleteGroup;
import com.liuji.julia.validator.UpdateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class TagReq {

    /**
     * 标签id
     */
    @Null(message = "创建时id必须为空", groups = {CreateGroup.class})
    @NotNull(message = "id不能为空", groups = {UpdateGroup.class, DeleteGroup.class})
    private Integer id;

    /**
     * 标签名
     */
    @NotBlank(message = "标签名不能为空", groups = {CreateGroup.class, UpdateGroup.class})
    private String tagName;

}
