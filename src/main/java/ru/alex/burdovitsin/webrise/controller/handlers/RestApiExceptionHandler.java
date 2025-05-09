package ru.alex.burdovitsin.webrise.controller.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.alex.burdovitsin.webrise.exception.UserNotFoundException;

@RestControllerAdvice
public class RestApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public String handleInvalidOperationException(UserNotFoundException ex) {
        return ex.getMessage();
    }

}
