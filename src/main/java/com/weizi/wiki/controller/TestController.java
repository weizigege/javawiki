package com.weizi.wiki.controller;

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
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
