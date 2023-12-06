package com.example.demo.response;

import com.example.demo.User;
import jakarta.annotation.Nullable;
import lombok.Data;


@Data
public class Initials {
    @Nullable
    public final String login, name, surname, patronymic;

    public Initials(User user) {
        login = user.login();
        name = user.name();
        surname = user.surname();
        patronymic = user.patronymic();
    }
}
