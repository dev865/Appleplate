package com.team.appleplate.domain.review.dto;

import lombok.Getter;

@Getter
public class ReviewCompleteCheckRequestDto {
    private final Long storeId;
    private final Long memberId;

    public ReviewCompleteCheckRequestDto(final Long storeId, final Long memberId) {
        this.storeId = storeId;
        this.memberId = memberId;
    }
}
