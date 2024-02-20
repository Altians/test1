package com.example.appdo.resp.pc;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class AuditResp implements Serializable {

    /**
     * id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容状态 1动态
     */
    private Integer contentStatus = 1;
    /**
     * 图片地址
     */
    private List<String> imgs;

    /**
     * 审核状态 0：待审核，1：审核通过，2：审核拒绝
     */
    private Integer auditStatus;
    /**
     * 发布时间
     */
    private Date releaseTime;
}
