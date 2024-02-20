package com.example.appdo.resp;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ContentDto implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;

    /**
     * 图片地址
     */
    private List<String> imgs;
}
