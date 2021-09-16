package com.weizi.wiki.controller;

import com.weizi.wiki.req.CategoryQueryReq;
import com.weizi.wiki.req.CategorySaveReq;
import com.weizi.wiki.resp.CommonResp;
import com.weizi.wiki.resp.CategoryQueryResp;
import com.weizi.wiki.resp.PageResp;
import com.weizi.wiki.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @program: wiki
 * @description
 * @author: hu
 * @create: 2021-07-31 19:11
 **/
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    private static final Logger LOG
    = LoggerFactory.getLogger(CategoryController.class);


    @GetMapping("/list")
    public CommonResp list(@Valid CategoryQueryReq req) {
        CommonResp<PageResp<CategoryQueryResp>> commonResp = new CommonResp();
        PageResp<CategoryQueryResp> list = categoryService.list(req);
        commonResp.setContent(list);

        return commonResp;
    }

    @GetMapping("/all")
    public CommonResp all() {
        CommonResp<List<CategoryQueryResp>> commonResp = new CommonResp();
        List<CategoryQueryResp> list = categoryService.all();
        commonResp.setContent(list);
        return commonResp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody CategorySaveReq req) {
        CommonResp commonResp = new CommonResp();
        categoryService.save(req);
        return commonResp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        int delete = categoryService.delete(id);
        LOG.info("delete:"+delete);
        return resp;
    }

}
