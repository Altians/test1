package com.example.appdo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Content implements Serializable {

    /**
     * id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 位置信息
     */
    private String location;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 置顶：1：置顶，0：取消置顶
     */
    private Integer top;
    /**
     * 置顶时间
     */
    private Date topTime;
    /**
     * 0：立即发布，1：定时发布
     */
    private Integer releaseType;
    /**
     * 发布时间
     */
    private Date releaseTime;
    /**
     * 状态
     */
    private Integer contentStatus;
    /**
     * 创建者
     */
    private Long createId;
    /**
     * 修改人
     */
    private Long updateId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 0（正常）、1（已删除）
     */
    private Integer deleted;
}
