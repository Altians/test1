package com.example.appdo.controller;


import com.example.appdo.entity.TestEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 脱敏测试
 */
@Slf4j
@RestController
public class TestController {
    @GetMapping("/test")
    public TestEntity test() {
        return TestEntity.builder()
                .userId(1234567890L)
                .userName("张三")
                .password("123456")
                .address("河南省郑州市中原区")
                .email("965125576@qq.com")
//                .fixedPhone("0838-5553792")
//                .mobilePhone("13888888888")
//                .carLicense("豫P3U253")
//                .bankCard("1679374639283740")
//                .idCard("412711223344556677")
//                .ipv4("192.168.1.236")
//                .ipv6("abcd:1234:aCA9:123:4567:089:0:0000")
//                .custom("289073458794")
//                .noMask("我是不需要数据脱敏的字段")
                .build();
    }
}
