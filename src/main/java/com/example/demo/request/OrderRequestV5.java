package com.example.demo.request;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderRequestV5 {
    @Nullable
    private String like;
    @Nullable
    private String regex;
    @Nullable
    private String surname;
    @Nullable
    private Integer lowerAge;
    @Nullable
    private Integer upperAge;
}
