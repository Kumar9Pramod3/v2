package com.speakingclock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SpeakingClockExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidTimeException.class)
    public ResponseEntity<Object> handleExceptions(InvalidTimeException exception, WebRequest webRequest) {
        ResponseEntity<Object> entity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        return entity;
    }
}
