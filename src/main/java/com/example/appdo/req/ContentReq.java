package com.example.appdo.req;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ContentReq implements Serializable {

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
     * 位置信息
     */
    private String location;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 图片、视频url
     */
    private List<String> urls;
    /**
     * 车系id
     */
    private VehicleVo vehicleVo;
    /**
     * 标签id
     */
    private List<TagVo> tagVos;

}
