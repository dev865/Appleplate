package com.team.appleplate.domain.member.exception;

import com.team.appleplate.global.exception.ErrorCode;
import com.team.appleplate.global.exception.GlobalException;

public class MemberNotFoundException extends GlobalException {
    public MemberNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
