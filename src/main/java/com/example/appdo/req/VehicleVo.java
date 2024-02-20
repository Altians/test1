package com.example.appdo.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class VehicleVo implements Serializable {

    /**
     * 车系id
     */
    private Long id;
    /**
     * 车系
     */
    private String vehicleName;

}
