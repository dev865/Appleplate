package com.team.appleplate.domain.review.service;

import com.team.appleplate.domain.member.domain.Member;
import com.team.appleplate.domain.member.exception.MemberNotFoundException;
import com.team.appleplate.domain.member.repository.MemberRepository;
import com.team.appleplate.domain.review.domain.Review;
import com.team.appleplate.domain.review.dto.ReviewCompleteCheckRequestDto;
import com.team.appleplate.domain.review.dto.ReviewCompleteCheckResponseDto;
import com.team.appleplate.domain.review.dto.ReviewRegisterRequestDto;


import com.team.appleplate.domain.review.dto.ReviewRegisterResponseDto;
import com.team.appleplate.domain.review.repository.ReviewQueryRepository;
import com.team.appleplate.domain.review.repository.ReviewRepository;
import com.team.appleplate.domain.store.exception.StoreNotFoundException;
import com.team.appleplate.domain.store.repository.StoreRepository;
import com.team.appleplate.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private static Logger log = LoggerFactory.getLogger("ReviewServiceImpl.class");

    private final ReviewRepository reviewRepository;
    private final ReviewQueryRepository queryRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    public ReviewRegisterResponseDto register(ReviewRegisterRequestDto reviewRegisterRequestDto) {
        Member existMember = memberRepository.findById(reviewRegisterRequestDto.getMemberId()).orElseThrow(()-> new MemberNotFoundException(ErrorCode.USER_NOT_FOUND));
        Store existStore = storeRepository.findById(reviewRegisterRequestDto.getStoreId()).orElseThrow(() -> new StoreNotFoundException(ErrorCode.STORE_NOT_FOUND));

        Review result = reviewRepository.save(Review.builder()
                                            .member(existMember)
                                            .store(existStore)
                                            .content(reviewRegisterRequestDto.getContent())
                                            .completeYn(reviewRegisterRequestDto.getCompleteYn())
                                            .grade(reviewRegisterRequestDto.getGrade())
                                            .build());

        return new ReviewRegisterResponseDto(result);
    }

    @Override
    public ReviewCompleteCheckResponseDto completeCheck(ReviewCompleteCheckRequestDto reviewCompleteCheckRequestDto) {
        Review review = queryRepository.completeCheck(reviewCompleteCheckRequestDto).orElseThrow();

        return new ReviewCompleteCheckResponseDto(review);
    }

}
