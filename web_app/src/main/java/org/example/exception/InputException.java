package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Illegal arguments")
public class InputException extends Exception {

    public InputException(String message) { super(message); }
}