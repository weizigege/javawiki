package com.weizi.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weizi.wiki.domain.Ebook;
import com.weizi.wiki.domain.EbookExample;
import com.weizi.wiki.mapper.EbookMapper;
import com.weizi.wiki.req.EbookQueryReq;
import com.weizi.wiki.req.EbookSaveReq;
import com.weizi.wiki.resp.EbookQueryResp;
import com.weizi.wiki.resp.PageResp;
import com.weizi.wiki.util.CopyUtil;
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
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;

    private static final Logger logger
            = LoggerFactory.getLogger(EbookService.class);

    public PageResp<EbookQueryResp> list(EbookQueryReq req) {

        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Ebook> ebooks = ebookMapper.selectByExample(ebookExample);
        PageInfo<Ebook> pageInfo = new PageInfo<>(ebooks);
        /*List<EbookResp> ebookResps = new ArrayList<>();
        for (Ebook ebook : ebooks) {
            EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);
            ebookResps.add(ebookResp);
        }*/
        List<EbookQueryResp> ebookRespslist = CopyUtil.copyList(ebooks, EbookQueryResp.class);
        PageResp<EbookQueryResp> resp = new PageResp<>();
        resp.setTotal((int) pageInfo.getTotal());
        resp.setList(ebookRespslist);
        return resp;
    }

    public void save(EbookSaveReq req) {
        Ebook ebook = CopyUtil.copy(req, Ebook.class);
        if (ObjectUtils.isEmpty(req.getId())){
            ebookMapper.insert(ebook);
        }
        ebookMapper.updateByPrimaryKey(ebook);

    }
}
