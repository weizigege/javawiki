package com.weizi.wiki.controller;

import com.weizi.wiki.domain.Ebook;
import com.weizi.wiki.resp.CommonResp;
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

    @Value("${ebook.hello:Ebook}")
    private String ebookHello;

    @RequestMapping("/hello")
    public String hello() {
        return "hello" + ebookHello;
    }

    @GetMapping("/list")
    public CommonResp list() {
        CommonResp<List<Ebook>> commonResp = new CommonResp();
        List<Ebook> list = ebookService.list();
        commonResp.setContent(list);
        return commonResp;
    }
}
