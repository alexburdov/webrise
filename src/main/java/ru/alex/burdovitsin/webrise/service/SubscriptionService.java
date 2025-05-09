package ru.alex.burdovitsin.webrise.service;

import ru.alex.burdovitsin.webrise.model.rest.SubscriptionDto;

import java.util.List;

public interface SubscriptionService {

    List<SubscriptionDto> addSubscriptionToUser(Long userId, SubscriptionDto subscriptionDto);

    List<SubscriptionDto> getUserSubscriptions(Long userId);

    List<SubscriptionDto> deleteUsersSubscription(Long userId, Long subscriptionId);

    List<String> getTopThreeSubscription();
}
