package com.example.appdo.controller.pc;

import com.example.appdo.req.pc.ActivityAddParam;
import com.example.appdo.req.pc.ActivityListParam;
import com.example.appdo.resp.pc.ActivityResp;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 活动管理
 */
@RestController
@RequestMapping("pc/activity")
public class ActivityController {

    /**
     * 活动分页查询列表
     * @param param
     * @return
     */
    @PostMapping("list")
    public List<ActivityResp> select(@RequestBody ActivityListParam param){
        List<ActivityResp> list = new ArrayList<>();
        return list;
    }

    /**
     * 新增活动
     * 修改活动
     * @param param
     * @return
     */
    @PostMapping("addActivity")
    public boolean addActivity(@RequestBody ActivityAddParam param){
        //参数有ID则走编辑接口，无则走新增
        return true;
    }

    /**
     * 活动详情
     * @param id
     * @return
     */
    @GetMapping("detail/{id}")
    public ActivityResp detail(@PathVariable("id") Long id){
        ActivityResp detail = new ActivityResp();
        return detail;
    }
}
