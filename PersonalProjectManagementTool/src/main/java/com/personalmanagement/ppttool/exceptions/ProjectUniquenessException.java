package com.personalmanagement.ppttool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectUniquenessException extends RuntimeException {

    public ProjectUniquenessException(String message) {
        super(message);
    }
}
