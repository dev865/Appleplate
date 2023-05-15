package com.team.appleplate.domain.review.repository;



import com.querydsl.jpa.impl.JPAQueryFactory;
import com.team.appleplate.domain.review.domain.Review;
import com.team.appleplate.domain.review.dto.ReviewCompleteCheckRequestDto;
import com.team.appleplate.domain.review.dto.ReviewCompleteCheckResponseDto;
import com.team.appleplate.domain.review.dto.ReviewRegisterResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.team.appleplate.domain.review.domain.QReview.review;

@Repository
@RequiredArgsConstructor
public class ReviewQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public Optional<Review> completeCheck(ReviewCompleteCheckRequestDto reviewCompleteCheckRequestDto){
        return Optional.ofNullable(jpaQueryFactory.selectFrom(review)
                .where(review.store.id.eq(reviewCompleteCheckRequestDto.getStoreId())
                        .and(review.member.id.eq(reviewCompleteCheckRequestDto.getMemberId()))
                        .and(review.completeYn.eq("N")))
                .fetchOne());
    }
}
