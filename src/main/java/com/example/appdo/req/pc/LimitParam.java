package com.example.appdo.req.pc;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LimitParam implements Serializable {

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 限制类型 1：警告，2：禁言
     */
    private Integer limitType;
    /**
     * 限制原因
     */
    private Integer limitReason;
    /**
     * 限制时长
     * 1:2h、2:24h、3:7天、4:30天、5:永久
     */
    private Integer startTime;

    /**
     * 留言
     */
    private String note;
}
