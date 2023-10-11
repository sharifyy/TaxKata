package com.github.sharifyy.domain;

import java.math.BigDecimal;

public record Tax(BigDecimal value, Denomination denomination) {
}
