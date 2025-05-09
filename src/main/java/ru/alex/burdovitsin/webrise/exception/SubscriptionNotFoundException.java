package ru.alex.burdovitsin.webrise.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubscriptionNotFoundException extends RuntimeException {
    private static final String SUBSCRIPTION_NOT_FOUND_MESSAGE = "Subscription not found with ID %d";

    public SubscriptionNotFoundException(long subscriptionId) {
        super(String.format(SUBSCRIPTION_NOT_FOUND_MESSAGE, subscriptionId));
        log.info(String.format(SUBSCRIPTION_NOT_FOUND_MESSAGE, subscriptionId));
    }
}
