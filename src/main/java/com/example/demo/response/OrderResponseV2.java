package com.example.demo.response;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.List;

@Value
public class OrderResponseV2 {

    @NotNull
    List<String> logins;

    @NotNull
    Integer numberOfUsers;
}
