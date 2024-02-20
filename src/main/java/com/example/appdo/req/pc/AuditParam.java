package com.example.appdo.req.pc;

import com.example.appdo.req.BaseReq;
import lombok.Data;

import java.util.Date;

@Data
public class AuditParam extends BaseReq {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 审核状态 0：待审核，1：审核通过，2：审核拒绝
     */
    private Integer auditStatus;
    /**
     * 标题
     */
    private String title;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
}
