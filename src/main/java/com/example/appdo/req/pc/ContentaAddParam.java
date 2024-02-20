package com.example.appdo.req.pc;

import com.example.appdo.req.TagVo;
import com.example.appdo.req.VehicleVo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ContentaAddParam implements Serializable {
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
     * 发布类型 0：立即发布，1：定时发布
     */
    private Integer releaseType;
    /**
     * 发布时间
     */
    private Date releaseTime;
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
     * 标签信息
     */
    private List<TagVo> tagVos;

}
