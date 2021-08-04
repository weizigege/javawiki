package com.weizi.wiki.mapper;

import com.weizi.wiki.domain.Test;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: wiki
 * @description
 * @author: hu
 * @create: 2021-08-05 00:42
 **/
@Component
public interface TestMapper {
    public List<Test> list();
}
