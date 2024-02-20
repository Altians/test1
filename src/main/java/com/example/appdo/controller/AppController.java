package com.example.appdo.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.appdo.entity.ContentReview;
import com.example.appdo.entity.UserInfo;
import com.example.appdo.request.UserInfoRequest;
import com.example.appdo.service.ContentReviewService;
import com.example.appdo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class AppController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ContentReviewService contentReviewService;

    @RequestMapping("app")
    public String test() throws InterruptedException {
        Thread.sleep(4000);
        return "success";
    }

    /**
     * 新增数据
     *
     * @param userInfo
     * @return
     */
    @RequestMapping("add")
    public boolean add(@RequestBody UserInfo userInfo){
        userInfo.setCreateId(1L);
        userInfo.setUpdateId(1L);
        userInfo.setDeleted(0);
        log.info("请求参数:{}", JSON.toJSONString(userInfo));
        return userInfoService.save(userInfo);
    }

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("select")
//    @DS("slave")
    public List<UserInfo> select(@RequestBody UserInfoRequest request){
        return userInfoService.selectAll(request);
    }

    @RequestMapping("/query")
    public List<ContentReview> query(){
        //查找所有数据
        List<ContentReview> list = contentReviewService.list(new QueryWrapper<ContentReview>().orderByDesc("review_time"));
        //结果集
        ArrayList<ContentReview> resultList = new ArrayList<>();
        //筛选一级
        for (ContentReview review : list) {
            if (0L == review.getParentId()){
                resultList.add(review);
            }
        }
        //查找子级节点
        for (ContentReview review : resultList) {
            review.setChildren(getChildren(list, review.getId()));
        }
        return resultList;
    }

    /**
     * 获取子节点
     * @param list
     * @param pid
     * @return
     */
    private static List<ContentReview> getChildren(List<ContentReview> list, Long pid) {
        ArrayList<ContentReview> childList = new ArrayList<>();
        for (ContentReview contentReview : list) {
            if (contentReview.getParentId() == pid){
                childList.add(contentReview);
            }
        }
/*
        //如果子节点下还有子节点，多级关系，那么递归调用下一级
        for (ContentReview child : childList) {
            child.setChildren(getChildren(list,child.getId()));
        }
        //退出
        if(childList.size() == 0){
            return new ArrayList<>();
        }*/

        return childList;
    }


}
