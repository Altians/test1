package com.example.appdo.resp;

import com.example.appdo.req.TagVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RecommendResp {
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
     * 描述
     */
    private String description;
    /**
     * 图片地址
     */
    private String img;
    /**
     * 评论量
     */
    private Integer totalComment;
    /**
     * 标签
     */
    private List<TagVo> tags;
    /**
     * 发布时间
     */
    private Date releaseTime;
}
