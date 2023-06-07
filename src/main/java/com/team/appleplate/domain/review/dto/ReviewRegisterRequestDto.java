package com.team.appleplate.domain.review.dto;


import com.team.appleplate.global.util.file.File;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
public class ReviewRegisterRequestDto {
    private final Long memberId;
    private final Long storeId;
    private final String content;
    private final String completeYn;
    private final double grade;

    public ReviewRegisterRequestDto(final Long memberId,final Long storeId,final String content,final String completeYn,final double grade) {
        this.memberId = memberId;
        this.storeId = storeId;
        this.content = content;
        this.completeYn = completeYn;
        this.grade = grade;
    }
}
