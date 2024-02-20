package com.example.appdo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.appdo.entity.ContentReview;
import com.example.appdo.mapper.ContentReviewMapper;
import com.example.appdo.service.ContentReviewService;
import com.example.appdo.service.UserInfoService;
import org.springframework.stereotype.Service;

@Service
public class ContentReviewServiceImpl extends ServiceImpl<ContentReviewMapper, ContentReview> implements ContentReviewService {

}
