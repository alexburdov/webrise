package ru.alex.burdovitsin.webrise.service.impl;

import org.springframework.stereotype.Service;
import ru.alex.burdovitsin.webrise.exception.SubscriptionNotFoundException;
import ru.alex.burdovitsin.webrise.exception.UserNotFoundException;
import ru.alex.burdovitsin.webrise.mappers.SubscriptionMapper;
import ru.alex.burdovitsin.webrise.model.jpa.Subscription;
import ru.alex.burdovitsin.webrise.model.jpa.User;
import ru.alex.burdovitsin.webrise.model.rest.SubscriptionDto;
import ru.alex.burdovitsin.webrise.repository.SubscriptionRepository;
import ru.alex.burdovitsin.webrise.repository.UserRepository;
import ru.alex.burdovitsin.webrise.service.SubscriptionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final UserRepository userRepository;

    private final SubscriptionRepository subscriptionRepository;

    private final SubscriptionMapper subscriptionMapper;

    public SubscriptionServiceImpl(UserRepository userRepository
            , SubscriptionRepository subscriptionRepository, SubscriptionMapper subscriptionMapper
    ) {
        this.userRepository = userRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionMapper = subscriptionMapper;
    }


    @Override
    public List<SubscriptionDto> addSubscriptionToUser(Long userId, SubscriptionDto subscriptionDto) {
        subscriptionDto.setUserId(userId);
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Subscription subscription = subscriptionMapper.toEntity(subscriptionDto);
        if (Objects.isNull(user.getSubscriptions())) {
            user.setSubscriptions(new ArrayList<>());
        }
        user.getSubscriptions().add(subscription);
        user = userRepository.save(user);
        return subscriptionMapper.toDtos(user.getSubscriptions());
    }

    @Override
    public List<SubscriptionDto> getUserSubscriptions(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        return subscriptionMapper.toDtos(user.getSubscriptions());
    }

    @Override
    public List<SubscriptionDto> deleteUsersSubscription(Long userId, Long subscriptionId) {
        Subscription subscription = subscriptionRepository.findById(subscriptionId).orElseThrow(() -> new SubscriptionNotFoundException(subscriptionId));
        if (Objects.equals(subscription.getUserId(), userId)) {
            subscriptionRepository.delete(subscription);
        }
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        return subscriptionMapper.toDtos(user.getSubscriptions());
    }

    @Override
    public List<String> getTopThreeSubscription() {
        return subscriptionRepository.getTopThree();
    }
}
