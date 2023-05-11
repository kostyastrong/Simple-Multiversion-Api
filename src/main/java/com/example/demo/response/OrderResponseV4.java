package com.example.demo.response;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.List;

@Value  // same v3
public class OrderResponseV4 {

    @NotNull
    @Deprecated(forRemoval = true)
    List<String> logins;

    @NotNull
    Integer numberOfUsers;

    @NotNull
    List<Initials> loginsV2;

}
