package com.example.appdo.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReviewReq implements Serializable {

    /**
     * 评论人
     */
    private Long userId;
    /**
     * 内容id
     */
    private Long contentId;
    /**
     * 被评论人
     */
    private Long replyId;
    /**
     * 评论内容
     */
    private String content;

    /**
     * 几级评论
     */
    private Integer level;

}
