package com.team.appleplate.domain.store.exception;

import com.team.appleplate.global.exception.ErrorCode;
import com.team.appleplate.global.exception.GlobalException;

public class StoreDuplicateException extends GlobalException {

    public StoreDuplicateException(ErrorCode errorCode) {
        super(errorCode);
    }
}
