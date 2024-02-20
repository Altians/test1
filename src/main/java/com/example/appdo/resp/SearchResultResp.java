package com.example.appdo.resp;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SearchResultResp implements Serializable {

    /**
     * 用户
     */
    private List<UserInfoDto> userInfoDtos;
    /**
     * 内容
     */
    private List<ContentDto> contentDtos;
//    private List<UserInfoDto> userInfoDtos;




}
