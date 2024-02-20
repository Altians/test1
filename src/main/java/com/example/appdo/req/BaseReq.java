package com.example.appdo.req;

import java.io.Serializable;

public class BaseReq implements Serializable {
    /**
     * 页数
     */
    private Integer pageNum = 1;
    /**
     * 条数
     */
    private Integer pageSize = 10;
}
