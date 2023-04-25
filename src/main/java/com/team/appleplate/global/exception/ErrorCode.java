package com.team.appleplate.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER NOT FOUND"),
    DUPLICATE_ACCOUNT(HttpStatus.BAD_REQUEST,"USER EMAIL DUPLICATE" );

    private final HttpStatus status;
    private final String message;
}
