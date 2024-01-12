package com.liuji.julia.controller;

import com.liuji.julia.api.request.TagReq;
import com.liuji.julia.api.response.Result;
import com.liuji.julia.entity.Tag;
import com.liuji.julia.service.TagService;
import com.liuji.julia.util.BeanCopyUtil;
import com.liuji.julia.validator.CreateGroup;
import com.liuji.julia.validator.DeleteGroup;
import com.liuji.julia.validator.RetrieveGroup;
import com.liuji.julia.validator.UpdateGroup;
import com.liuji.julia.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public Result listTags() {
        System.out.println("/tag/list");
        List<Tag> list = tagService.list();
        List<TagVo> tagVos = BeanCopyUtil.copyBeanList(list, TagVo.class);
        return Result.ok().data(tagVos);
    }

    @PostMapping("/add")
    public Result addTag(@Validated(CreateGroup.class) TagReq tagReq) {
        Tag tagEntity = BeanCopyUtil.copyBean(tagReq, Tag.class);
        tagService.save(tagEntity);
        return Result.ok();
    }

    @DeleteMapping("/delete")
    public Result deleteTag(@Validated(DeleteGroup.class) TagReq tagReq) {
        tagService.removeById(tagReq.getId());
        return Result.ok();
    }

    @PostMapping("/update")
    public Result updateTag(@Validated(UpdateGroup.class) TagReq tagReq) {
        Tag tagEntity = BeanCopyUtil.copyBean(tagReq, Tag.class);
        tagService.updateById(tagEntity);
        return Result.ok();
    }

    @GetMapping("/retrieve")
    public Result retrieveTag(@Validated(RetrieveGroup.class) TagReq tagReq) {
        Tag tagEntity = tagService.getById(tagReq.getId());
        System.out.println(tagEntity.getId() + tagEntity.getTagName());
        TagVo tagVo = BeanCopyUtil.copyBean(tagEntity, TagVo.class);
        return Result.ok().data(tagVo);
    }

}
