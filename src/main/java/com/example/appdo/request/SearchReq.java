package com.example.appdo.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class SearchReq implements Serializable {
    /**
     * 搜索内容
     */
    private String keyword;

    /**
     * 搜索类型
     * 1：动态，2：用户，3：话题
     */
    private Integer searchType;

}
