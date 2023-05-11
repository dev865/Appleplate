package com.team.appleplate.domain.review.dto;


import com.team.appleplate.domain.member.domain.Member;
import com.team.appleplate.domain.review.domain.Review;
import com.team.appleplate.domain.store.domain.Store;
import com.team.appleplate.global.util.file.File;
import lombok.Getter;

import java.util.List;
@Getter
public class ReviewRegisterRequestDto {
    private Long memberId;
    private Long storeId;
    private String content;
    private String completeYn;
    private double grade;

//    파일 미적용
//    private List<File> fileList;

    public Review toEntity() {
        return Review.builder()
                        .member(Member.ReviewRegisterMemberId().memberId(memberId).build())
                        .store(Store.ReviewRegisterStoreId().storeId(storeId).build())
                        .content(content)
                        .completeYn(completeYn)
                        .grade(grade)
                        .build();
    }
}
