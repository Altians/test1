package com.example.appdo.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SelfDataReq implements Serializable {

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
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;
}
