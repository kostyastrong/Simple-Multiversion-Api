package com.example.demo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    public String login;
    public String name;
    public String surname;
    public String patronymic;  // отчество
    public Integer age;
}
