package com.example.appdo.resp;

import com.example.appdo.req.ReviewVo;
import com.example.appdo.req.TagVo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RecommendDetail implements Serializable {

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String headPic;
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
    private List<String> imgs;

    /**
     * 位置信息
     */
    private String location;
    /**
     * 评论量
     */
    private Integer commentNum;
    /**
     * 标签
     */
    private List<TagVo> tags;

}
