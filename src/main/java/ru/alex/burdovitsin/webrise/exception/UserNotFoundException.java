package ru.alex.burdovitsin.webrise.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserNotFoundException extends RuntimeException {
    private static final String USER_NOT_FOUND_MESSAGE = "User not found with ID %d";

    public UserNotFoundException(long userId) {
        super(String.format(USER_NOT_FOUND_MESSAGE, userId));
        log.info(String.format(USER_NOT_FOUND_MESSAGE, userId));
    }
}
