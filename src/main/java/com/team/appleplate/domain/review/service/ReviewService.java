package com.team.appleplate.domain.review.service;

import com.team.appleplate.domain.review.dto.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface ReviewService {
    ReviewRegisterResponseDto register (ReviewRegisterRequestDto reviewRegisterRequestDto, List<MultipartFile> files);
    ReviewCompleteCheckResponseDto completeCheck(ReviewCompleteCheckRequestDto reviewCompleteCheckRequestDto);
}