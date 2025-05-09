package ru.alex.burdovitsin.webrise.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.burdovitsin.webrise.service.SubscriptionService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/top")
    public ResponseEntity<List<String>> getTopThreeSubscription() {
        List<String> topThree = subscriptionService.getTopThreeSubscription();
        return ResponseEntity.ok(topThree);
    }
}
