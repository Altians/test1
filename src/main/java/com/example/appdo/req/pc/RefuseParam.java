package com.example.appdo.req.pc;

import lombok.Data;

import java.io.Serializable;
@Data
public class RefuseParam implements Serializable {

    /**
     * 内容id
     */
    private Long id;
    /**
     * 拒绝原因
     */
    private String refuseReason;

    private Integer refuseType;
}
