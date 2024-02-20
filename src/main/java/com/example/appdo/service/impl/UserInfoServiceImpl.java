package com.example.appdo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.appdo.entity.UserInfo;
import com.example.appdo.mapper.UserInfoMapper;
import com.example.appdo.request.UserInfoRequest;
import com.example.appdo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public List<UserInfo> selectAll(UserInfoRequest request) {
        log.info("分页查询参数:{}", JSON.toJSONString(request));
        Page<UserInfo> page = new Page<>(request.getPageNum(),request.getPageSize());
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        if (request.getUserId()!= null){
            wrapper.eq("user_id",request.getUserId());
        }
        if (StringUtils.isNotEmpty(request.getNickName())){
            wrapper.like("nick_name",request.getNickName());
        }
        Page<UserInfo> userInfoPage = userInfoMapper.selectPage(page, wrapper);

        return userInfoPage.getRecords();
    }
}
