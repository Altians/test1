package com.example.appdo.resp.pc;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ActivityResp implements Serializable {
    /**
     * 活动id
     */
    private Long id;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 参与人数
     */
    private Integer partialNum;

    /**
     * 活动类型
     */
    private Integer activityType;
    /**
     * 报名对象
     */
    private String applyObj;
    /**
     * 活动人数
     */
    private Integer activityNum;
    /**
     * 活动费用 1：免费
     */
    private Integer activityFee;
    /**
     * 活动奖励 1：实物礼品
     */
    private Integer activityAward;
    /**
     * 参与方式 1：发布动态
     */
    private Integer partialWay;
    /**
     * 标题图
     */
    private String pic;
    /**
     * 活动介绍
     */
    private String activityIntro;
    /**
     * 活动开始时间
     */
    private Date startTime;
    /**
     * 活动结束时间
     */
    private Date endTime;
}
