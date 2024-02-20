package com.example.appdo.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class TagVo implements Serializable {
    /**
     * 标签id
     */
    private Long id;
    /**
     * 标签名称
     */
    private String tagName;

}
