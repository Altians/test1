package com.example.appdo.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ReviewVo implements Serializable {

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date reviewTime;
    /**
     * 是否作者  true 是，false 否
     */
    private boolean author;

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String headPic;
}
