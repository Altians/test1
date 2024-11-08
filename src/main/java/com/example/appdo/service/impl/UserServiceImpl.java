package com.example.appdo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.appdo.entity.domain.User;
import com.example.appdo.mapper.UserMapper;
import com.example.appdo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lzxxz
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-10-24 09:40:33
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> userList() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.exists("SELECT 1 FROM user_extra WHERE user.user_id = user_extra.id");
        List<User> list = this.list(wrapper);
        return list;
    }
}




