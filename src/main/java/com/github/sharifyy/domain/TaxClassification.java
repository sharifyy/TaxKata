package com.github.sharifyy.domain;

public sealed interface TaxClassification permits SelfEnterpriseClassification, SASClassification {
    Tax tax(AnnualTurnOver annualTurnOver);
}
