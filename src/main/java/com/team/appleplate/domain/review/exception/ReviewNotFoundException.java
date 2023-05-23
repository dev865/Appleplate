package com.team.appleplate.domain.review.exception;

import com.team.appleplate.global.exception.ErrorCode;
import com.team.appleplate.global.exception.GlobalException;

public class ReviewNotFoundException extends GlobalException {
    public ReviewNotFoundException(ErrorCode errorCode){
        super(errorCode);
    }
}
