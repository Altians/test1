package com.example.appdo.controller;

import com.example.appdo.request.SearchReq;
import com.example.appdo.resp.RecommendDetail;
import com.example.appdo.resp.SearchHistoryResp;
import com.example.appdo.resp.SearchResultResp;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页搜索
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    /**
     * 历史搜索记录
     * @param userId
     * @return
     */
    @GetMapping("{userId}")
    public List<SearchHistoryResp> searchHistory(@PathVariable("userId") Long userId){
        //搜索最近10条记录
        List<SearchHistoryResp> list = new ArrayList<>();
        return list;
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @PostMapping("delete")
    public boolean delete(@RequestBody List<Long> ids){
        return true;
    }

    /**
     * 搜索
     * @param req
     * @return
     */
    @PostMapping("keyword")
    public SearchResultResp delete(@RequestBody SearchReq req){
        SearchResultResp resp = new SearchResultResp();
        return resp;
    }

}
