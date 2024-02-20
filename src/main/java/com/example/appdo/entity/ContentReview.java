package com.example.appdo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@TableName("content_review")
public class ContentReview implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 动态id
     */
    private Long dynamicId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 父id
     */
    private Long parentId;
    private Long create_id;
    private Long update_id;
    /**
     * 层级
     */
    private Integer level;
    /**
     * 架：0：正常，1：已下架
     */
    private Integer deleted;
    /**
     * 官方回复 0：否，1：是
     */
    private Integer offical;
    /**
     * 评论时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date reviewTime;
    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(exist = false)
    private List<ContentReview> children;
}
