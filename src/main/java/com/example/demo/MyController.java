package com.example.demo;

import com.example.demo.filters.*;
import com.example.demo.request.*;
import com.example.demo.response.*;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Каждый новый endpoint отображает инкремент. То есть то, как один конкретный endpoint бы меняться,
 * чтобы сохранять обратную совместимость.
 * <p>
 * Это значит, что к разным endpoint-ам v1, v2, v3 нужно относиться так, как будто менялся один и
 * тот же. Каждый инкремент объявлен отдельным endpoint-ом для наглядности.
 * <p>
 * Смотрите MyControllerTest для примера проверки обратной совместимости.
 */
@RestController
@Validated
public class MyController {

    User user1 = User.builder().login("kostya").age(19).surname("matros").build();
    User user2 = User.builder().login("kolya").age(65).surname("pilesos").build();
    User user3 = User.builder().login("kamil").age(30).surname("sos").build();
    User user4 = User.builder().login("kamil").age(29).surname("nasos").build();

    List<User> users = new ArrayList<>(List.of(new User[]{user1, user2, user3, user4}));


    // Информация о заказе передается в body.
    // Аннотация @Valid выполняет проверки внутри переданного DTO по аннотациям @NotNull
    @PostMapping("/api/order/v1")
    public OrderResponseV1 createOrder(@Valid @RequestBody OrderRequestV1 request) {
        String login = request.getLike();

        ArrayList<Filter> filters = new ArrayList<>();
        filters.add(new LoginFilter(login));
        CompoundFilter compoundFilter = new CompoundFilter(filters);

        ArrayList<String> logins = compoundFilter.validStream(users).map(User::getLogin).collect(Collectors.toCollection(ArrayList::new));

        return new OrderResponseV1(logins);
    }


    @PostMapping("/api/order/v2")
    public OrderResponseV2 createOrderV2(@Valid @RequestBody OrderRequestV2 request) {
        String login = request.getLike();

        ArrayList<Filter> filters = new ArrayList<>();
        filters.add(new LoginFilter(login));
        CompoundFilter compoundFilter = new CompoundFilter(filters);

        ArrayList<String> logins = compoundFilter.validStream(users).map(User::getLogin).collect(Collectors.toCollection(ArrayList::new));

        return new OrderResponseV2(logins, users.size());
    }


    @PostMapping("/api/order/v3")
    public OrderResponseV3 createOrderV3(@Valid @RequestBody OrderRequestV3 request) {
        String login = request.getLike();

        ArrayList<Filter> filters = new ArrayList<>();
        filters.add(new LoginFilter(login));
        CompoundFilter compoundFilter = new CompoundFilter(filters);

        ArrayList<String> logins = compoundFilter.validStream(users).map(User::getLogin).collect(Collectors.toCollection(ArrayList::new));

        return new OrderResponseV3(
                logins,
                users.size(),
                // deprecated поле также нужно заполнять корректными значениями, потому что клиенты еще могут его читать
                compoundFilter.validStream(users).map(Initials::new)
                        .toList()
        );
    }

    @PostMapping("/api/order/v4")
    public OrderResponseV4 createOrderV4(@Valid @RequestBody OrderRequestV4 request) {
        String login = request.getLike();
        String regex = request.getRegex();

        ArrayList<Filter> filters = new ArrayList<>();
        filters.add(new RegexFilter(regex));
        if (login == null || regex == null) {
            filters.add(new LoginFilter(login));
        }
        CompoundFilter compoundFilter = new CompoundFilter(filters);
        ArrayList<String> logins = compoundFilter.validStream(users).map(User::getLogin).collect(Collectors.toCollection(ArrayList::new));

        return new OrderResponseV4(
                logins,
                users.size(),
                // deprecated поле также нужно заполнять корректными значениями, потому что клиенты еще могут его читать
                compoundFilter.validStream(users)
                        .map(Initials::new)
                        .toList()
        );
    }

    @PostMapping("/api/order/v5")
    public OrderResponseV5 createOrderV5(@Valid @RequestBody OrderRequestV5 request) {
        String login = request.getLike();
        String regex = request.getRegex();
        Integer lowerAge = request.getLowerAge();
        Integer upperAge = request.getUpperAge();
        String surname = request.getSurname();

        ArrayList<Filter> filters = new ArrayList<>();
        filters.add(new RegexFilter(regex));
        if (login == null || regex == null) {
            filters.add(new LoginFilter(login));
        }
        filters.add(InitialsFilter.builder().surname(surname).build());
        filters.add(new AgeFilter(lowerAge, upperAge));
        CompoundFilter compoundFilter = new CompoundFilter(filters);

        ArrayList<String> logins = compoundFilter.validStream(users).map(User::getLogin).collect(Collectors.toCollection(ArrayList::new));

        return new OrderResponseV5(
                logins,
                users.size(),
                compoundFilter.validStream(users)
                        .map(Initials::new)
                        .toList()
        );
    }
}
