package com.example.appdo.req.pc;

import com.example.appdo.req.BaseReq;
import lombok.Data;

import java.util.Date;

@Data
public class ContentListParam extends BaseReq {

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 标题
     */
    private String title;
    /**
     * 状态
     */
    private Integer contentStatus;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
}
