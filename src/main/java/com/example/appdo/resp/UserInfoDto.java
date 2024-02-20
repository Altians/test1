package com.example.appdo.resp;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoDto implements Serializable {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 头像
     */
    private String img;

    /**
     * 关注状态
     * 1:已关注，0：取消关注
     */
    private Integer status;
}
