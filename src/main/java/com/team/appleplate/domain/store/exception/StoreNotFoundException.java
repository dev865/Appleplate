package com.team.appleplate.domain.store.exception;

import com.team.appleplate.global.exception.ErrorCode;
import com.team.appleplate.global.exception.GlobalException;

public class StoreNotFoundException extends GlobalException {

    public StoreNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
