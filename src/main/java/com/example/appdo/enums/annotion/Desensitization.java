package com.example.appdo.enums.annotion;

import com.example.appdo.enums.DesensitizationSerialize;
import com.example.appdo.enums.DesensitizationTypeEnum;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//运行时生效
@Retention(RetentionPolicy.RUNTIME)
//可用在字段上
@Target(ElementType.FIELD)
//此注解可以点进去看一下是一个元注解，主要是用户打包其他注解一起使用
@JacksonAnnotationsInside
//该注解的作用就是可自定义序列化，可以用在注解上，方法上，字段上，类上，运行时生效等等，根据提供的序列化类里面的重写方法实现自定义序列化。
@JsonSerialize(using = DesensitizationSerialize.class)
public @interface Desensitization {
    /**
     * 脱敏数据类型，在CUSTOM的时候，start和end生效
     */
    DesensitizationTypeEnum type() default DesensitizationTypeEnum.CUSTOM;

    /**
     * 脱敏开始位置（包含）
     */
    int start() default 0;

    /**
     * 脱敏结束位置（不包含）
     */
    int end() default 0;
}
