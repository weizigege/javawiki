package com.weizi.wiki.req;


import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @program: wiki
 * @description
 * @author: hu
 * @create: 2021-09-06 23:17
 **/
public class PageReq {

    private int page;

    @NotNull(message = "【每页条数不能为空】")
    @Max(value = 1000, message = "【每页条数不能超过1000】")
    private int size;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PageReq{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }
}
