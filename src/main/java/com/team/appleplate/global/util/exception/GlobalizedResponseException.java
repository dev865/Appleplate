package com.team.appleplate.global.util.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalizedResponseException {
    @ExceptionHandler(GlobalException.class)
    public final ResponseEntity<?> handleUserNotFoundException(final GlobalException e, WebRequest request) {

        return ResponseEntity.status(e.getErrorCode().getStatus()).body(new ExceptionResponse(e.getErrorCode().getMessage(),request.getDescription(false)));
    }
}
