package ru.alex.burdovitsin.webrise.controller.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.alex.burdovitsin.webrise.exception.SubscriptionNotFoundException;
import ru.alex.burdovitsin.webrise.exception.UserNotFoundException;

@Slf4j
@RestControllerAdvice
public class RestApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public String handleInvalidOperationException(UserNotFoundException ex) {
        log.error(ex.getMessage());
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SubscriptionNotFoundException.class)
    public String handleInvalidOperationException(SubscriptionNotFoundException ex) {
        log.error(ex.getMessage());
        return ex.getMessage();
    }
}
