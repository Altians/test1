package com.example.appdo.resp.pc;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContentTotalResp implements Serializable {
    /**
     * 总数
     */
    private Integer total;
    /**
     * 上架数
     */
    private Integer upNum;
    /**
     * 下架数
     */
    private Integer downNum;
}
