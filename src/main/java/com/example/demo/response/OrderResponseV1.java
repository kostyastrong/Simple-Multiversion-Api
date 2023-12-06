package com.example.demo.response;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.List;



public record OrderResponseV1(@NotNull List<String> logins) {
}
