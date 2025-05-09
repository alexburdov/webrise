package ru.alex.burdovitsin.webrise.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.alex.burdovitsin.webrise.model.jpa.User;
import ru.alex.burdovitsin.webrise.model.rest.UserDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {SubscriptionMapper.class})
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "login", target = "login")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "isActive", target = "isActive")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "patronymic", target = "patronymic")
    @Mapping(source = "subscriptions", target = "subscriptions")
    UserDto toUserDto(User user);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "login", target = "login")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "isActive", target = "isActive")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "patronymic", target = "patronymic")
    @Mapping(source = "subscriptions", target = "subscriptions")
    User toUser(UserDto userDto);
}
