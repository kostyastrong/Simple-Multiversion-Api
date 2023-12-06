package com.example.demo.request;

import jakarta.annotation.Nullable;

public record OrderRequestV3(@Nullable String like, @Nullable String regex, @Nullable String surname,
                             @Nullable Integer lowerAge, @Nullable Integer upperAge) {
}
