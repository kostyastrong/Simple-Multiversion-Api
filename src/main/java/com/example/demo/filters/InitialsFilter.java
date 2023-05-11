package com.example.demo.filters;

import com.example.demo.User;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InitialsFilter implements Filter {

    @Nullable
    String name, surname, patronymic;

    @Override
    public Boolean isValid(User user) {
        if (name == null && surname == null && patronymic == null) {
            return true;
        }
        String uName = name, uSurname = surname, uPatronymic = patronymic;
        if (user.getName() != null) {
            uName = user.getName();
        }
        if (user.getSurname() != null) {
            uSurname = user.getSurname();
        }
        if (user.getPatronymic() != null) {
            uPatronymic = user.getPatronymic();
        }

        return Objects.equals(uName, name)
                && Objects.equals(uSurname, surname)
                && Objects.equals(uPatronymic, patronymic);
    }
}
