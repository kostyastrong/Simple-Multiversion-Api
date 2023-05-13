package com.example.demo;

import lombok.Builder;


@Builder
public record User(String login, String name, String surname, String patronymic, Integer age) {
}
