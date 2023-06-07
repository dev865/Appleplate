package com.team.appleplate.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER NOT FOUND"),
    DUPLICATE_ACCOUNT(HttpStatus.BAD_REQUEST,"USER EMAIL DUPLICATE" ),
    DUPLICATE_STORE_NAME(HttpStatus.BAD_REQUEST, "STORE NAME DUPLICATE"),
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE NOT FOUND"),
    DELETED_STORE(HttpStatus.NOT_FOUND, "STORE HAS BEEN DELETED"),
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW NOT FOUND");

    private final HttpStatus status;
    private final String message;
}
