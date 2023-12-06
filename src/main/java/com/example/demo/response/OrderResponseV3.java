package com.example.demo.response;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.List;


public record OrderResponseV3(@Deprecated(forRemoval = true) @NotNull List<String> logins,
                              @NotNull Integer numberOfUsers, @NotNull List<Initials> loginsV2) {

}
