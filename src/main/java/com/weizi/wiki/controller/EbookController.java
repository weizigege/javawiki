package com.weizi.wiki.controller;

import com.weizi.wiki.req.EbookQueryReq;
import com.weizi.wiki.req.EbookSaveReq;
import com.weizi.wiki.resp.CommonResp;
import com.weizi.wiki.resp.EbookQueryResp;
import com.weizi.wiki.resp.PageResp;
import com.weizi.wiki.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    public CommonResp list(EbookQueryReq req) {
        CommonResp<PageResp<EbookQueryResp>> commonResp = new CommonResp();
        PageResp<EbookQueryResp> list = ebookService.list(req);
        commonResp.setContent(list);

        return commonResp;
    }
    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq req) {
        CommonResp commonResp = new CommonResp();
        ebookService.save(req);
        return commonResp;
    }



}
