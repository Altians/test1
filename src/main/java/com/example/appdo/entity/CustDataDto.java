package com.example.appdo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustDataDto implements Serializable {

    //客户ID
    private String CUST_ID;
    //客户编号=经销商code
    private String CUST_NO;
    //经销商名称
    private String CUST_NAME;
    //基地
    private String COMPANY_NAME;
    //销售主体
    private String AGENT_FUNNAME;
    //商品属性 1:成车
    private int ITEM_TYPE;
    //商品属性
    private String ITEM_TYPE_NAME;
    //商品ID
    private String ITEM_ID;
    //商品编码
    private String ITEM_CODE;
    //商品名称
    private String ITEM_NAME;
    //商品型号
    private String MODEL;
    //商品规格
    private String ITEM_DESC;
    //颜色ID
    private String COLOR_ID;
    //颜色编码
    private String COLOR_CODE;
    //颜色
    private String COLOE_NAME;
    //贴花ID
    private String TH_ID;
    //贴花编码
    private String TH_CODE;
    //贴花
    private String TH_NAME;
    //实际发货数量
    private int QTY;
    //开单数量
    private String KD_QTY;

}
