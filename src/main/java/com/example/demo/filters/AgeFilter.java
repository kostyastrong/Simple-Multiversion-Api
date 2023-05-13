package com.example.demo.filters;

import com.example.demo.User;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AgeFilter implements Filter {

    @Nullable
    Integer lowerBound, upperBound;  // [lower, upper]

    @Override
    public Boolean isValid(User user) {
        if (lowerBound == null && upperBound == null) {
            return true;
        }
        if (user.age() == null) {
            return false;
        }
        if (lowerBound != null && user.age() < lowerBound) {
            return false;
        }
        return upperBound == null || user.age() <= upperBound;
    }
}
