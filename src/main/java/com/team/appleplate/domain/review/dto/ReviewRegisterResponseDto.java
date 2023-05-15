package com.team.appleplate.domain.review.dto;

import com.team.appleplate.domain.review.domain.Review;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ReviewRegisterResponseDto {
    private final Long id;
    private final String content;
    private final double grade;
    private final String completeYn;
    private final Long memberId;
    private final Long storeId;

    public ReviewRegisterResponseDto(Review review){
        this.id = review.getId();
        this.content = review.getContent();
        this.grade = review.getGrade();
        this.completeYn = review.getCompleteYn();
        this.memberId = review.getMember().getId();
        this.storeId = review.getStore().getId();
    }
}
