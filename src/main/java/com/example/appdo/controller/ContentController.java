package com.example.appdo.controller;

import com.example.appdo.req.*;
import com.example.appdo.resp.HomePageResp;
import com.example.appdo.resp.RecommendDetail;
import com.example.appdo.resp.RecommendResp;
import com.example.appdo.resp.UserInfoDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 移动端
 */
@RestController
@RequestMapping("/content")
public class ContentController {

    /**
     * 推荐/关注列表
     * @param req
     * @return
     */
    @PostMapping("list")
    public List<RecommendResp> select(@RequestBody BaseReq req){
        //关注列表 先查询关注的用户id
        //跟进用户id查询内容倒序

        List<RecommendResp> list = new ArrayList<>();
        return list;
    }

    /**
     * 发布
     * @param req
     * @return
     */
    @PostMapping("addContent")
    public boolean addContent(@RequestBody ContentReq req){
        return true;
    }

    /**
     * 车系查询
     * @param
     * @return
     */
    @GetMapping("queryVehicle")
    public List<VehicleVo> queryVehicle(){
        List<VehicleVo> vehicleVos = new ArrayList<>();
        return vehicleVos;
    }

    /**
     * 标签查询
     * @param
     * @return
     */
    @GetMapping("queryTag")
    public List<TagVo> queryTag(){
        List<TagVo> tagVos = new ArrayList<>();
        return tagVos;
    }

    /**
     * 推荐详情
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public RecommendDetail queryTag(@PathVariable("id") Long id){
        RecommendDetail detail = new RecommendDetail();
        return detail;
    }

    /**
     * 推荐详情-评论
     * @param id
     * @return
     */
    @GetMapping("/review/{id}")
    public List<ReviewVo> review(@PathVariable("id") Long id){
        List<ReviewVo> reviewVos = new ArrayList<>();
        return reviewVos;
    }

    /**
     * 添加评论
     * @param req
     * @return
     */
    @PostMapping("addComment")
    public boolean addComment(@RequestBody ReviewReq req){
        return true;
    }

    /**
     * 标签关联内容列表
     * @param id
     * @return
     */
    @GetMapping("/tag/{id}")
    public List<RecommendResp> contentByTagId(@PathVariable("id") Long id){
        List<RecommendResp> list = new ArrayList<>();
        return list;
    }

    /**
     * 个人主页
     * @param userId
     * @return
     */
    @GetMapping("/home/{userId}")
    public HomePageResp selfHomePage(@PathVariable("userId") Long userId){
        HomePageResp homePage = new HomePageResp();
        return homePage;
    }


    /**
     * 个人主页-关注/粉丝列表
     * @param userId
     * @param type 1:粉丝，2:关注
     * @return
     */
    @GetMapping("/home/attention/{userId}/{type}")
    public List<UserInfoDto> selfHomePageAttention(@PathVariable("userId") Long userId,@PathVariable("type") Integer type){
        //我关注的人
        //SELECT * FROM `attention` WHERE user_id = '' AND follow_status = 1
        //我的粉丝
        //SELECT * FROM `attention` WHERE user_id = ''
        List<UserInfoDto> infoDtos = new ArrayList<>();
        return infoDtos;
    }

    /**
     * 个人资料保存
     * @param req
     * @return
     */
    @PostMapping("save/selfData")
    public boolean selfData(@RequestBody SelfDataReq req){
        return true;
    }


}
