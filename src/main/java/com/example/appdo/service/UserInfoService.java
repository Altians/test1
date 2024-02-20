package com.example.appdo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.appdo.entity.UserInfo;
import com.example.appdo.request.UserInfoRequest;

import java.util.List;

public interface UserInfoService extends IService<UserInfo> {

    List<UserInfo> selectAll(UserInfoRequest request);
}
