package com.asteroides.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Value needs to be between 1 and 7.")
public class ValueNotAcceptedException extends  Exception{
    public ValueNotAcceptedException() {
    }
}
