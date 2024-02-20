package com.example.appdo.resp;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class HomePageResp implements Serializable {

    /**
     * 关注量
     */
    private Integer attentionNum;
    /**
     * 粉丝量
     */
    private Integer fansNum;
    /**
     * 内容列表
     */
    private List<RecommendResp> contents;
}
