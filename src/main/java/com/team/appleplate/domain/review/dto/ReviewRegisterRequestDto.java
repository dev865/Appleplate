package com.team.appleplate.domain.review.dto;


import lombok.Getter;

@Getter
public class ReviewRegisterRequestDto {
    private final Long memberId;
    private final Long storeId;
    private final String content;
    private final String completeYn;
    private final double grade;

//    파일 미적용
//    private List<File> fileList;

    public ReviewRegisterRequestDto(final Long memberId,final Long storeId,final String content,final String completeYn,final double grade) {
        this.memberId = memberId;
        this.storeId = storeId;
        this.content = content;
        this.completeYn = completeYn;
        this.grade = grade;
    }


}
