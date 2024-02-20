package com.example.appdo.req.pc;

import com.example.appdo.req.BaseReq;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ActivityListParam extends BaseReq {


    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动类型
     */
    private Integer activityType;
    /**
     * 活动状态
     */
    private Integer activityStatus;

}
