package com.example.appdo.request;

import com.example.appdo.entity.UserInfo;
import lombok.Data;

@Data
public class UserInfoRequest extends UserInfo {

    /**
     * 页数
     */
    private Integer pageNum = 1;
    /**
     * 条数
     */
    private Integer pageSize = 10;

}
