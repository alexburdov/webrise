package ru.alex.burdovitsin.webrise.repository;

import org.springframework.data.repository.CrudRepository;
import ru.alex.burdovitsin.webrise.model.jpa.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
