package com.example.demo.request;

import org.springframework.lang.Nullable;

// В первой версии заказа передаем только like-username
public record OrderRequestV1(@Nullable String like, @Nullable String _unused) {
}
