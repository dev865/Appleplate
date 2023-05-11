package com.team.appleplate.domain.review.service;

import com.team.appleplate.domain.member.domain.Member;
import com.team.appleplate.domain.member.repository.MemberRepository;
import com.team.appleplate.domain.review.domain.Review;
import com.team.appleplate.domain.review.dto.ReviewRegisterRequestDto;


import com.team.appleplate.domain.review.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private static Logger log = LoggerFactory.getLogger("ReviewServiceImpl.class");

    @Autowired
    private ReviewRepository reviewRepo;

    @Override
    public void register(ReviewRegisterRequestDto reviewRegisterRequestDto) {

        Review result = reviewRepo.save(reviewRegisterRequestDto.toEntity());

        if (result.getCompleteYn() == "N"){
            // return 1 or 0
        }
        // Long storeId = review.getStore().getStoreId();
        // return 가게id를 이용하여 가게 상세 페이지로 돌아가기

    }
}
