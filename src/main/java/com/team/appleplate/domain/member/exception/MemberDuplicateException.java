package com.team.appleplate.domain.member.exception;

import com.team.appleplate.global.exception.ErrorCode;
import com.team.appleplate.global.exception.GlobalException;

public class MemberDuplicateException extends GlobalException {
    public MemberDuplicateException(ErrorCode errorCode) {
        super(errorCode);
    }
}
