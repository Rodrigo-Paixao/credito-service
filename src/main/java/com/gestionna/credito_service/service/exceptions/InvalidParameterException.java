package com.gestionna.credito_service.service.exceptions;

import org.springframework.http.HttpStatus;
import lombok.Getter;

@Getter
public class InvalidParameterException extends RuntimeException {
    private final HttpStatus status;

    public InvalidParameterException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
    }

    public InvalidParameterException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
