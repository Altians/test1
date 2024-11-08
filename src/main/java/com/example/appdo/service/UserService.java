package com.example.appdo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.appdo.entity.domain.User;

import java.util.List;

/**
* @author lzxxz
* @description 针对表【user】的数据库操作Service
* @createDate 2024-10-24 09:40:33
*/
public interface UserService extends IService<User> {

    List<User> userList();

}
