package com.example.appdo.resp.pc;

import com.example.appdo.req.TagVo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ContentResp implements Serializable {
    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String headPic;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 图片地址
     */
    private String img;

    /**
     * 位置信息
     */
    private String location;

    /**
     * 标签
     */
    private List<TagVo> tags;

    /**
     * 置顶：1：置顶，0：取消置顶
     */
    private Integer top;
    /**
     * 评论量
     */
    private Integer commentNum;
    /**
     * 浏览量
     */
    private Integer viewNum;
    /**
     * 状态 0：上架中，1：已下架
     */
    private Integer contentStatus;

    /**
     * 发布时间
     */
    private Date releaseTime;

}
