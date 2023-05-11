package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.Nullable;

// same as in v1
@Data
@AllArgsConstructor
public class OrderRequestV3 {
    @Nullable
    private String like;

    @Nullable
    private String _unused;
}
