package ru.alex.burdovitsin.webrise.service.impl;

import org.springframework.stereotype.Service;
import ru.alex.burdovitsin.webrise.exception.UserNotFoundException;
import ru.alex.burdovitsin.webrise.mappers.UserMapper;
import ru.alex.burdovitsin.webrise.model.jpa.User;
import ru.alex.burdovitsin.webrise.model.rest.UserDto;
import ru.alex.burdovitsin.webrise.repository.UserRepository;
import ru.alex.burdovitsin.webrise.service.UserService;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private static final String PASSWORD_HIDE_MESSAGE = "******";

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto user) {
        User toSave = userMapper.toUser(user);
        User createdUser = userRepository.save(toSave);
        return userMapper.toUserDto(createdUser);
    }

    @Override
    public UserDto findUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        user.setPassword(PASSWORD_HIDE_MESSAGE);
        return userMapper.toUserDto(user);
    }

    @Override
    public UserDto updateUser(Long userId, UserDto user) {
        User toUpdate = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        String login = user.getLogin();
        if (Objects.nonNull(login) && !login.equals(toUpdate.getLogin())) {
            toUpdate.setLogin(login);
        }
        String password = user.getPassword();
        if (Objects.nonNull(password) && !password.equals(toUpdate.getPassword())) {
            toUpdate.setPassword(password);
        }
        Boolean isActive = user.getIsActive();
        if (Objects.nonNull(isActive) && !isActive.equals(toUpdate.getIsActive())) {
            toUpdate.setIsActive(isActive);
        }
        String name = user.getName();
        if (Objects.nonNull(name) && !name.equals(toUpdate.getName())) {
            toUpdate.setName(name);
        }
        String surname = user.getSurname();
        if (Objects.nonNull(surname) && !surname.equals(toUpdate.getSurname())) {
            toUpdate.setSurname(surname);
        }
        String patronymic = user.getPatronymic();
        if (Objects.nonNull(patronymic) && !patronymic.equals(toUpdate.getPatronymic())) {
            toUpdate.setPatronymic(patronymic);
        }
        toUpdate = userRepository.save(toUpdate);
        toUpdate.setPassword(PASSWORD_HIDE_MESSAGE);
        return userMapper.toUserDto(toUpdate);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
