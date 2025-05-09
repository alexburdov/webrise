package ru.alex.burdovitsin.webrise.model.rest;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@ToString
public class SubscriptionDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -4472709513413365260L;

    private Long id;

    @NotNull
    private Long userId;

    private Boolean isActive;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private String url;
}
