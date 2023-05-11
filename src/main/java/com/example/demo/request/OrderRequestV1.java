package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.Nullable;

// В первой версии заказа передаем только like-username
@Data
@AllArgsConstructor
public class OrderRequestV1 {
    @Nullable
    private String like;

    @Nullable
    private String _unused;
}
