package com.example.demo.filters;

import com.example.demo.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Filter {
    Boolean isValid(User user);

    default List<User> validList(List<User> users) {
        return users.stream().filter(this::isValid).collect(Collectors.toList());
    }

    default Stream<User> validStream(List<User> users) {
        return users.stream().filter(this::isValid);
    }
}
