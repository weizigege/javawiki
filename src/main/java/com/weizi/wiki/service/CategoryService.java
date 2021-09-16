package com.weizi.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weizi.wiki.domain.Category;
import com.weizi.wiki.domain.CategoryExample;
import com.weizi.wiki.mapper.CategoryMapper;
import com.weizi.wiki.req.CategoryQueryReq;
import com.weizi.wiki.req.CategorySaveReq;
import com.weizi.wiki.resp.CategoryQueryResp;
import com.weizi.wiki.resp.PageResp;
import com.weizi.wiki.util.CopyUtil;
import com.weizi.wiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: wiki
 * @description
 * @author: hu
 * @create: 2021-08-05 00:53
 **/
@Service
public class CategoryService {
    //花纵酒
    @Resource
    SnowFlake snowFlake;

    @Resource
    private CategoryMapper categoryMapper;

    private static final Logger logger
            = LoggerFactory.getLogger(CategoryService.class);

    public List<CategoryQueryResp> all() {

        CategoryExample categoryExample = new CategoryExample();
        categoryExample.setOrderByClause("sort asc");
        List<Category> categorys = categoryMapper.selectByExample(categoryExample);
        //列表复制
        List<CategoryQueryResp> list = CopyUtil.copyList(categorys, CategoryQueryResp.class);


        return list;
    }

    public PageResp<CategoryQueryResp> list(CategoryQueryReq req) {

        CategoryExample categoryExample = new CategoryExample();
        categoryExample.setOrderByClause("sort asc");
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Category> categorys = categoryMapper.selectByExample(categoryExample);
        PageInfo<Category> pageInfo = new PageInfo<>(categorys);
        /*List<CategoryResp> categoryResps = new ArrayList<>();
        for (Category category : categorys) {
            CategoryResp categoryResp = CopyUtil.copy(category, CategoryResp.class);
            categoryResps.add(categoryResp);
        }*/
        List<CategoryQueryResp> categoryRespslist = CopyUtil.copyList(categorys, CategoryQueryResp.class);
        PageResp<CategoryQueryResp> resp = new PageResp<>();
        resp.setTotal((int) pageInfo.getTotal());
        resp.setList(categoryRespslist);
        return resp;
    }

    public void save(CategorySaveReq req) {
        Category category = CopyUtil.copy(req, Category.class);
        if (ObjectUtils.isEmpty(req.getId())){
            category.setId(snowFlake.nextId());
            categoryMapper.insert(category);
        }else {
            categoryMapper.updateByPrimaryKey(category);
        }
    }

    public int delete(Long id) {
        int i = categoryMapper.deleteByPrimaryKey(id);
        return i;
    }
}
