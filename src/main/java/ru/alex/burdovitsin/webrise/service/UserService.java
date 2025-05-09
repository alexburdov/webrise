package ru.alex.burdovitsin.webrise.service;

import ru.alex.burdovitsin.webrise.model.rest.UserDto;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto findUserById(Long userId);

    UserDto updateUser(Long userId, UserDto user);

    void deleteUser(Long userId);

}
