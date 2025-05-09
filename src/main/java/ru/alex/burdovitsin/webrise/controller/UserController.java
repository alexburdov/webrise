package ru.alex.burdovitsin.webrise.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.burdovitsin.webrise.model.rest.SubscriptionDto;
import ru.alex.burdovitsin.webrise.model.rest.UserDto;
import ru.alex.burdovitsin.webrise.repository.UserRepository;
import ru.alex.burdovitsin.webrise.service.SubscriptionService;
import ru.alex.burdovitsin.webrise.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    private final SubscriptionService subscriptionService;

    public UserController(UserService userService, SubscriptionService subscriptionService, UserRepository userRepository) {
        this.userService = userService;
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/echo")
    public String echo() {
        return "ECHO";
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserDto createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> findUserById(@PathVariable Long userId) {
        log.info("Find user by id: {}", userId);
        UserDto user = userService.findUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @RequestBody UserDto user) {
        UserDto updatedUser = userService.updateUser(userId, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/subscriptions")
    public ResponseEntity<List<SubscriptionDto>> addSubscriptionToUser(@PathVariable Long userId, @RequestBody SubscriptionDto subscription) {
        List<SubscriptionDto> newSubscriptions = subscriptionService.addSubscriptionToUser(userId, subscription);
        return ResponseEntity.ok(newSubscriptions);
    }

    @GetMapping("{userId}/subscriptions")
    public ResponseEntity<List<SubscriptionDto>> getUserSubscriptions(@PathVariable Long userId) {
        List<SubscriptionDto> subscriptions = subscriptionService.getUserSubscriptions(userId);
        return ResponseEntity.ok(subscriptions);
    }

    @DeleteMapping("/users/{userId}/subscriptions/{subscriptionId}")
    public ResponseEntity<List<SubscriptionDto>> deleteUsersSubscription(@PathVariable Long userId, @PathVariable Long subscriptionId) {
        List<SubscriptionDto> subscriptions = subscriptionService.deleteUsersSubscription(userId, subscriptionId);
        return ResponseEntity.ok(subscriptions);
    }
}
