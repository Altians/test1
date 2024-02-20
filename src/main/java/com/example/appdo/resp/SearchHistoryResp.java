package com.example.appdo.resp;

import lombok.Data;

import java.io.Serializable;

@Data
public class SearchHistoryResp implements Serializable {

    /**
     * id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 搜索词
     */
    private String keyword;
}
