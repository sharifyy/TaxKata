package com.github.sharifyy.domain;

public sealed interface Address {
    record None() implements Address {}
    record RegisteredAddress(City city, Street street, String number) implements Address {}

}
