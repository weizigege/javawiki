package com.weizi.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weizi.wiki.config.WikiApplication;
import com.weizi.wiki.domain.Ebook;
import com.weizi.wiki.domain.EbookExample;
import com.weizi.wiki.domain.Test;
import com.weizi.wiki.mapper.EbookMapper;
import com.weizi.wiki.mapper.TestMapper;
import com.weizi.wiki.req.EbookReq;
import com.weizi.wiki.resp.EbookResp;
import com.weizi.wiki.resp.PageResp;
import com.weizi.wiki.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: wiki
 * @description
 * @author: hu
 * @create: 2021-08-05 00:53
 **/
@Service
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;

    private static final Logger logger
            = LoggerFactory.getLogger(EbookService.class);

    public PageResp<EbookResp> list(EbookReq req){

        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if(!ObjectUtils.isEmpty(req.getName())){
            criteria.andNameLike("%"+req.getName()+"%");
        }
        PageHelper.startPage(req.getPage(),req.getSize());
        List<Ebook> ebooks = ebookMapper.selectByExample(ebookExample);
        PageInfo<Ebook> pageInfo = new PageInfo<>(ebooks);
        /*List<EbookResp> ebookResps = new ArrayList<>();
        for (Ebook ebook : ebooks) {
            EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);
            ebookResps.add(ebookResp);
        }*/
        List<EbookResp> ebookRespslist = CopyUtil.copyList(ebooks, EbookResp.class);
        PageResp<EbookResp> resp =new PageResp<>();
        resp.setTotal((int) pageInfo.getTotal());
        resp.setList(ebookRespslist);
        return resp;
    }

}
