package com.example.appdo.controller.owner;

import com.example.appdo.entity.domain.User;
import com.example.appdo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @Author: crh
 * @CreateDate: 2024/10/24
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUserInfo(){
        return userService.userList();
    }

    @PostMapping("/test")
    public void getUserInfo(@RequestBody List<Long> ids){
        System.out.println(ids);
    }

    @GetMapping("/test1")
    public void getUser(){
        System.out.println("success");
    }

    @GetMapping("/test12")
    public void getUser1(){
        System.out.println("success");
    }

}
