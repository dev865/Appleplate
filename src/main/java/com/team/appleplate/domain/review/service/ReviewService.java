package com.team.appleplate.domain.review.service;

import com.team.appleplate.domain.review.dto.ReviewRegisterRequestDto;


import java.util.List;

public interface ReviewService {
    void register (ReviewRegisterRequestDto reviewRegisterRequestDto);
}