package com.team.appleplate.domain.review.controller;

import com.team.appleplate.domain.review.dto.ReviewCompleteCheckRequestDto;
import com.team.appleplate.domain.review.dto.ReviewCompleteCheckResponseDto;
import com.team.appleplate.domain.review.dto.ReviewRegisterRequestDto;
import com.team.appleplate.domain.review.dto.ReviewRegisterResponseDto;
import com.team.appleplate.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

/**
 * 로직 정리
 *
 * 1. 등록
 *  1-1 RequestBody에 리뷰내용 받아오기
 *  1-2 저장하기
 *  1-3 저장한 리뷰의 가게id를 사용하여 돌아갈 주소 정하기
 *
 * 2. completeYn 확인하기
 *  2-1 가게번호와 멤버번호 가져오기
 *  2-2 리뷰 findAllbyStoreId
 *  2-3 찾아온 리뷰중 멤버번호를 이용하여 completeYn = N 찾기
 *      2-3-1 멤버의 모든 리뷰가 complete "Y" 일시 return httpStatus.REVIEW_NOT_FOUND
 *      2-3-2 미완성리뷰가 존재시 그 리뷰를 가져가기
 *          2-3-2-1 보내준 리뷰를 그대로 사용한다
 *          2-3-2-2 보내준 리뷰를 사용안하고 삭제한다. (/review/delete/1) (아직 미구현)
 *
 *
 *
 *
 *
 *
 **/

@RestController
@RequestMapping("/review/*")
@RequiredArgsConstructor
public class ReviewController {
    private static Logger log = LoggerFactory.getLogger(ReviewController.class);

    private final ReviewService reviewService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody ReviewRegisterRequestDto reviewRegisterRequestDto) { // form형식은 @RequestBody말고 다른것으로 시도

        ReviewRegisterResponseDto reviewRegisterResponseDto = reviewService.register(reviewRegisterRequestDto);

//        return 주소 (store 상세 페이지)
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/store/{storeId}").buildAndExpand(reviewRegisterRequestDto.getStoreId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @GetMapping("/complete-check/{storeId}/{memberId}")
    public ResponseEntity<ReviewCompleteCheckResponseDto> completeCheck(@PathVariable("storeId") Long storeId, @PathVariable("memberId") Long memberId) {
        ReviewCompleteCheckResponseDto reviewCompleteCheckResponseDto = reviewService.completeCheck(new ReviewCompleteCheckRequestDto(storeId, memberId));

        // return 주소 (호출한 주소로 미완성 리뷰 가져가기)
        // ResponseEntity.ok()의 uri는 수정이 불가능한것같다.
        return ResponseEntity.ok(reviewCompleteCheckResponseDto);
    }
}
