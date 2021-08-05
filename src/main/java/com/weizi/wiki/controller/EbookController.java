package com.weizi.wiki.controller;

import com.weizi.wiki.domain.Ebook;
import com.weizi.wiki.req.EbookReq;
import com.weizi.wiki.resp.CommonResp;
import com.weizi.wiki.resp.EbookResp;
import com.weizi.wiki.service.EbookService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: wiki
 * @description
 * @author: hu
 * @create: 2021-07-31 19:11
 **/
@RestController
@RequestMapping("/ebook")
public class EbookController {
    @Resource
    private EbookService ebookService;





    @GetMapping("/list")
    public CommonResp list(EbookReq req) {
        CommonResp<List<EbookResp>> commonResp = new CommonResp();
        List<EbookResp> list = ebookService.list(req);
        commonResp.setContent(list);
        return commonResp;
    }
}
