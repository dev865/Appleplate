package com.team.appleplate.domain.store.exception;

import com.team.appleplate.global.exception.ErrorCode;
import com.team.appleplate.global.exception.GlobalException;

public class StoreDeleteException extends GlobalException {

    public StoreDeleteException(ErrorCode errorCode) {
        super(errorCode);
    }
}
