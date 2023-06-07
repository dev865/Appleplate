package com.team.appleplate.domain.review.controller;

import com.team.appleplate.domain.review.dto.*;
import com.team.appleplate.domain.review.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/review/*")
@RequiredArgsConstructor
public class ReviewController {
    private static Logger log = LoggerFactory.getLogger(ReviewController.class);
    private final ReviewService reviewService;

    @PostMapping("/register")
    @ApiOperation(value = "리뷰 등록")
    public ResponseEntity register( @RequestPart(name = "files" , required=false) List<MultipartFile> files,
                                    @RequestPart(name="reviewRegisterRequestDto") ReviewRegisterRequestDto reviewRegisterRequestDto) {
        ReviewRegisterResponseDto reviewRegisterResponseDto = reviewService.register(reviewRegisterRequestDto, files);

        URI location = ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/store/{storeId}")
                        .buildAndExpand(reviewRegisterRequestDto.getStoreId())
                        .toUri();

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
