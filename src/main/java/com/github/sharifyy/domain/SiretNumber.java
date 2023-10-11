package com.github.sharifyy.domain;

import java.util.Objects;

public record SiretNumber(String value) {

    public SiretNumber {
        Objects.requireNonNull(value);
        // todo business validation for siret number
        if (value.length() != 14)
            throw new RuntimeException("siret number is invalid");
    }

    public static SiretNumber of(long number) {
        return new SiretNumber(String.valueOf(number));
    }

    public static SiretNumber of(String number) {
        return new SiretNumber(number);
    }

}
