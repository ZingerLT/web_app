package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Illegal arguments")
public class LenghtException extends Exception
{
    public LenghtException (String message) { super(message); }
}
