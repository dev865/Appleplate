package com.team.appleplate.domain.review.service;

import com.team.appleplate.domain.review.dto.ReviewCompleteCheckRequestDto;
import com.team.appleplate.domain.review.dto.ReviewCompleteCheckResponseDto;
import com.team.appleplate.domain.review.dto.ReviewRegisterRequestDto;
import com.team.appleplate.domain.review.dto.ReviewRegisterResponseDto;

public interface ReviewService {
    ReviewRegisterResponseDto register (ReviewRegisterRequestDto reviewRegisterRequestDto);
}