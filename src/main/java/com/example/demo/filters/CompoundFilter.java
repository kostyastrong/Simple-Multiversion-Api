package com.example.demo.filters;

import com.example.demo.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CompoundFilter implements Filter {

    @NotNull
    List<? extends Filter> filters;

    @Override
    public Boolean isValid(User user) {
        boolean valid = true;
        for (Filter filter : filters) {
            valid = valid && filter.isValid(user);
        }
        return valid;
    }
}
