package com.example.appdo.controller.pc;

import com.example.appdo.req.pc.AuditParam;
import com.example.appdo.req.pc.LimitParam;
import com.example.appdo.req.pc.RefuseParam;
import com.example.appdo.resp.pc.AuditDetailResp;
import com.example.appdo.resp.pc.AuditResp;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容审核
 */
@RestController
@RequestMapping("pc/audit")
public class AuditController {
    /**
     * 内容审核分页查询列表
     * @param param
     * @return
     */
    @PostMapping("list")
    public List<AuditResp> select(@RequestBody AuditParam param){
        List<AuditResp> list = new ArrayList<>();
        return list;
    }

    /**
     * 审核详情
     * @param id
     * @return
     */
    @GetMapping("detail/{id}")
    public AuditDetailResp detail(@PathVariable("id") Long id){
        //逻辑删除
        AuditDetailResp resp = new AuditDetailResp();
        return resp;
    }

    /**
     * 审核通过
     * @param id
     * @return
     */
    @GetMapping("pass/{id}")
    public boolean pass(@PathVariable("id") Long id){
        //逻辑删除
        return true;
    }

    /**
     * 审核拒绝
     * @param param
     * @return
     */
    @PostMapping("refuse")
    public boolean refuse(@RequestBody RefuseParam param){
        //逻辑删除
        return true;
    }

    /**
     * 用户限制
     * @param param
     * @return
     */
    @PostMapping("limit")
    public boolean limit(@RequestBody LimitParam param){
        LimitParam limitParam = new LimitParam();
        //逻辑删除
        return true;
    }

}
