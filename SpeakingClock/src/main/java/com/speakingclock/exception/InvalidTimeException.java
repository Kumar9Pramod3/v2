package com.speakingclock.exception;

public class InvalidTimeException extends RuntimeException {
    public InvalidTimeException(final String e) {
        super(e);
    }
}
