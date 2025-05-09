package ru.alex.burdovitsin.webrise.model.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@ToString
public class UserDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 2071814800709656981L;

    private Long id;

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private Boolean isActive;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    private String patronymic;

    private List<SubscriptionDto> subscriptions;
}
