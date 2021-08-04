package com.weizi.wiki.service;

import com.weizi.wiki.domain.Test;
import com.weizi.wiki.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: wiki
 * @description
 * @author: hu
 * @create: 2021-08-05 00:53
 **/
@Service
public class TestService {
    @Resource
    private TestMapper testMapper;

    public List<Test> list(){
        return testMapper.list();
    }

}
