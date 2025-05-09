package ru.alex.burdovitsin.webrise.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.alex.burdovitsin.webrise.model.jpa.Subscription;

import java.util.List;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {

    // Можно было через sream API - но средствами БД будет лучше
    @Query("SELECT s.name FROM Subscription s GROUP BY s.name ORDER BY count(1) DESC LIMIT 3")
    List<String> getTopThree();
}
