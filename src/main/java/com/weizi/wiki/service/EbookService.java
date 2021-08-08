package com.weizi.wiki.service;

import com.weizi.wiki.domain.Ebook;
import com.weizi.wiki.domain.EbookExample;
import com.weizi.wiki.domain.Test;
import com.weizi.wiki.mapper.EbookMapper;
import com.weizi.wiki.mapper.TestMapper;
import com.weizi.wiki.req.EbookReq;
import com.weizi.wiki.resp.EbookResp;
import com.weizi.wiki.util.CopyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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

    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%"+req.getName()+"%");
        List<Ebook> ebooks = ebookMapper.selectByExample(ebookExample);
        List<EbookResp> ebookResps = new ArrayList<>();
        for (Ebook ebook : ebooks) {
            /*EbookResp ebookResp = new EbookResp();
            BeanUtils.copyProperties(ebook,ebookResp);*/
            EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);
            ebookResps.add(ebookResp);
        }
        List<EbookResp> ebookRespslist = CopyUtil.copyList(ebooks, EbookResp.class);

        return ebookRespslist;
    }

}
