package com.team.appleplate.domain.review.service;

import com.team.appleplate.domain.member.domain.Member;
import com.team.appleplate.domain.member.exception.MemberNotFoundException;
import com.team.appleplate.domain.member.repository.MemberRepository;
import com.team.appleplate.domain.review.domain.Review;
import com.team.appleplate.domain.review.dto.*;


import com.team.appleplate.domain.review.repository.ReviewQueryRepository;
import com.team.appleplate.domain.review.repository.ReviewRepository;
import com.team.appleplate.domain.store.domain.Store;
import com.team.appleplate.domain.store.exception.StoreNotFoundException;
import com.team.appleplate.domain.store.repository.StoreRepository;
import com.team.appleplate.global.exception.ErrorCode;
import com.team.appleplate.global.util.file.File;
import com.team.appleplate.global.util.file.FileHandler;
import com.team.appleplate.global.util.file.dto.FileResponseDto;
import com.team.appleplate.global.util.file.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private static Logger log = LoggerFactory.getLogger("ReviewServiceImpl.class");

    private final ReviewRepository reviewRepository;
    private final ReviewQueryRepository queryRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final FileRepository fileRepository;
    private final FileHandler fileHandler;

    @Override
    public ReviewRegisterResponseDto register(ReviewRegisterRequestDto reviewRegisterRequestDto, List<MultipartFile> files) {
        Member existMember = memberRepository.findById(reviewRegisterRequestDto.getMemberId()).orElseThrow(()-> new MemberNotFoundException(ErrorCode.USER_NOT_FOUND));
        Store existStore = storeRepository.findById(reviewRegisterRequestDto.getStoreId()).orElseThrow(() -> new StoreNotFoundException(ErrorCode.STORE_NOT_FOUND));

        Review result = reviewRepository.save(Review.builder()
                                            .member(existMember)
                                            .store(existStore)
                                            .content(reviewRegisterRequestDto.getContent())
                                            .completeYn(reviewRegisterRequestDto.getCompleteYn())
                                            .grade(reviewRegisterRequestDto.getGrade())
                                            .build());
        // 멀티파트파일 File엔티티화 및 프로젝트내 저장
        FileResponseDto fileResponseDto = fileHandler.parseFileInfo(files);

        for (File file: fileResponseDto.getFileList()) {
            review.addFile(file);
            fileRepository.save(file);
        }
        return new ReviewRegisterResponseDto(review);
    }

    @Override
    public ReviewCompleteCheckResponseDto completeCheck(ReviewCompleteCheckRequestDto reviewCompleteCheckRequestDto) {
        Review review = queryRepository.completeCheck(reviewCompleteCheckRequestDto).orElseThrow();

        return new ReviewCompleteCheckResponseDto(review);
    }

}
