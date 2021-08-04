package com.weizi.wiki.controller;

import com.weizi.wiki.domain.Test;
import com.weizi.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class TestController {
    @Resource
    private TestService testService;

    @Value("${test.hello:Test}")
    private String testHello;

    @RequestMapping("/hello")
    public String hello() {
        return "hello" + testHello;
    }

    @GetMapping("/test")
    public List<Test> list() {
        return testService.list();
    }
}
