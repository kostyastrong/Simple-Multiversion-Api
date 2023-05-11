package com.example.demo.filters;

import com.example.demo.User;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginFilter implements Filter {
    @Nullable
    public String login;

    @Override
    public Boolean isValid(User user) {
        if (login == null) {
            return true;
        }
        return user.login.equals(login);
    }

}
