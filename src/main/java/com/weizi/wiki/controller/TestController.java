package com.weizi.wiki.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: wiki
 * @description
 * @author: hu
 * @create: 2021-07-31 19:11
 **/
@RestController
public class TestController {
    @Value("${test.hello:Test}")
    private String testHello;

    @RequestMapping("/hello")
    public String hello(){
        return "hello"+testHello;
    }
}
