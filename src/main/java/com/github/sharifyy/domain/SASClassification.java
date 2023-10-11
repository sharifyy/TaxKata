package com.github.sharifyy.domain;

import java.math.BigDecimal;

public final class SASClassification implements TaxClassification {
    private static final BigDecimal taxPercentage = new BigDecimal("0.33");

    @Override
    public Tax tax(AnnualTurnOver annualTurnOver) {
        return new Tax(annualTurnOver.value().multiply(taxPercentage), annualTurnOver.denomination());
    }
}
