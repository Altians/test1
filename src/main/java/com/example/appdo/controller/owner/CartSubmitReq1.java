package com.example.appdo.controller.owner;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: crh
 * @CreateDate: 2024/10/30
 * @Description:
 */
@Data
public class CartSubmitReq1 implements Serializable {
    /**
     * ids
     */
    @NotNull(message = "ids不能为null")
    @Size(min = 1, message = "ids不能为空")
    private List<Long> ids;

    /**
     * 序号
     */
    private Integer serialNo;
}
