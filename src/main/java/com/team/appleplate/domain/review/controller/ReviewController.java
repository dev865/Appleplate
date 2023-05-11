package com.team.appleplate.domain.review.controller;



import com.team.appleplate.domain.review.dto.ReviewRegisterRequestDto;
import com.team.appleplate.domain.review.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review/*")
@RequiredArgsConstructor
public class ReviewController {
    private static Logger log = LoggerFactory.getLogger(ReviewController.class);
    @Autowired
    private final ReviewService reviewService;

    @PostMapping("/register")
    public void register(@RequestBody ReviewRegisterRequestDto reviewRegisterRequestDto) { // form형식은 @RequestBody말고 다른것으로 시도
        reviewService.register(reviewRegisterRequestDto);

    }
}