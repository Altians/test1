package com.example.appdo.entity;

import com.example.appdo.enums.DesensitizationTypeEnum;
import com.example.appdo.enums.annotion.Desensitization;
import lombok.Builder;
import lombok.Data;

/**
 * 数据脱敏
 */
@Data
@Builder
public class TestEntity {

    @Desensitization(type = DesensitizationTypeEnum.USER_ID)
    private Long userId;
    @Desensitization(type = DesensitizationTypeEnum.CHINESE_NAME)
    private String userName;
    @Desensitization(type = DesensitizationTypeEnum.EMAIL)
    private String email;
    @Desensitization(type = DesensitizationTypeEnum.ADDRESS)
    private String address;
    private String password;

}
