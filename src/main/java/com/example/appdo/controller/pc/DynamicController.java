package com.example.appdo.controller.pc;

import com.example.appdo.req.BaseReq;
import com.example.appdo.req.ReviewVo;
import com.example.appdo.req.pc.ContentListParam;
import com.example.appdo.req.pc.ContentaAddParam;
import com.example.appdo.resp.pc.ContentResp;
import com.example.appdo.resp.pc.ContentTotalResp;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态管理
 */
@RestController
@RequestMapping("pc/content")
public class DynamicController {

    /**
     * 动态-列表
     * @param param
     * @return
     */
    @PostMapping("list")
    public List<ContentResp> select(@RequestBody ContentListParam param){
        List<ContentResp> list = new ArrayList<>();
        return list;
    }

    /**
     * 动态-统计
     * @param param
     * @return
     */
    @PostMapping("count")
    public ContentTotalResp count(@RequestBody ContentListParam param){
        ContentTotalResp totalResp = new ContentTotalResp();
        return totalResp;
    }

    /**
     * 动态-新增
     * 动态-编辑
     * @param req
     * @return
     */
    @PostMapping("add")
    public boolean add(@RequestBody ContentaAddParam req){
        //参数有ID则走编辑接口，无则走新增
        return true;
    }


    /**
     * 动态-详情
     * @param id
     * @return
     */
    @GetMapping("detail/{id}")
    public ContentResp detail(@PathVariable("id") Long id){
        ContentResp detail = new ContentResp();
        return detail;
    }

    /**
     * 动态详情-评论
     * @param id
     * @return
     */
    @GetMapping("review/{id}")
    public List<ReviewVo> review(@PathVariable("id") Long id){
        List<ReviewVo> detail = new ArrayList<>();
        return detail;
    }

   /* *//**
     * 上架、下架
     * @param id
     * @return
     *//*
    @GetMapping("upOrDown")
    public boolean upOrDown(@PathVariable("id") Long id){
        //逻辑删除
        return true;
    }*/
    /**
     * 动态-上架
     * @param id
     * @return
     */
    @GetMapping("upOrDown1")
    public boolean up(@PathVariable("id") Long id){
        //逻辑删除
        return true;
    }
    /**
     * 动态-下架
     * @param id
     * @return
     */
    @GetMapping("upOrDown")
    public boolean down(@PathVariable("id") Long id){
        //逻辑删除
        return true;
    }
}
