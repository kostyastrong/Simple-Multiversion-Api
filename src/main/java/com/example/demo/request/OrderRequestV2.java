package com.example.demo.request;

import jakarta.annotation.Nullable;

public record OrderRequestV2(@Nullable String like, @Nullable String regex) {

}
