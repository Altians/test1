package com.example.appdo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: gzx
 * @CreateDate: 2024/3/21
 * @Description:
 */
@Data
public class AlarmInfoAddNewParam implements Serializable {
    /**
     * 告警类型0:业务日志 1：慢sql告警
     */
    private Integer alarmType;

    /**
     * 告警服务
     */
    private String alarmService;

    /**
     * 告警类名
     */
    private String alarmClass;

    /**
     * 日志追踪id
     */
    private String traceId;

    /**
     * skywalking 追踪id
     */
    private String tid;

    /**
     * 告警内容
     */
    private String alarmContent;

    /**
     * 负责人uid,多个uid逗号隔开
     */
    private String chargerUids;

    /**
     * kibana地址
     */
    private String kibana;
    /**
     * skywalking地址
     */
    private String skywalking;
}
