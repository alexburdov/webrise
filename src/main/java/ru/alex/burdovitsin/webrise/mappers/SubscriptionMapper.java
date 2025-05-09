package ru.alex.burdovitsin.webrise.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.alex.burdovitsin.webrise.model.jpa.Subscription;
import ru.alex.burdovitsin.webrise.model.rest.SubscriptionDto;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubscriptionMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "isActive", target = "isActive")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "url", target = "url")
    SubscriptionDto toDto(Subscription subscription);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "isActive", target = "isActive")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "url", target = "url")
    Subscription toEntity(SubscriptionDto dto);

    List<SubscriptionDto> toDtos(List<Subscription> subscriptions);

    List<Subscription> toEntities(List<SubscriptionDto> dtos);
}
