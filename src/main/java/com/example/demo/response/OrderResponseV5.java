package com.example.demo.response;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.List;

@Value
public class OrderResponseV5 {

    @NotNull
    @Deprecated(forRemoval = true)
    List<String> logins;

    @NotNull
    Integer numberOfUsers;

    @NotNull
    List<Initials> loginsV2;
}
