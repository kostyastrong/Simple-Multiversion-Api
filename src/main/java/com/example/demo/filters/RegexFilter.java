package com.example.demo.filters;

import com.example.demo.User;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class RegexFilter implements Filter {

    @Nullable
    public String pattern;

    @Override
    public Boolean isValid(User user) {
        if (pattern == null) {
            return true;
        }
        return user.login().matches(pattern);
    }
}
