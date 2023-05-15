package com.team.appleplate.domain.review.dto;

import com.team.appleplate.domain.review.domain.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
public class ReviewCompleteCheckResponseDto {

    private final Long id;
    private final double grade;
    private final String content;

    @Builder
    public ReviewCompleteCheckResponseDto(Review review){
        this.id = review.getId();
        this.grade = review.getGrade();
        this.content = review.getContent();
    }

}
