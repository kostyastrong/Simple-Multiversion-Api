package com.example.demo.request;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderRequestV4 {

    @Nullable
    private String like;
    @Nullable
    private String regex;
}
