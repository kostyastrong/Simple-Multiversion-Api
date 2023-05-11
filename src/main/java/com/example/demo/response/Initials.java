package com.example.demo.response;

import com.example.demo.User;
import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Value;


@Data
public class Initials {
    @Nullable
    String login, name, surname, patronymic;

    public Initials(User user) {
        login = user.getLogin();
        name = user.getName();
        surname = user.getSurname();
        patronymic = user.getPatronymic();
    }
}
