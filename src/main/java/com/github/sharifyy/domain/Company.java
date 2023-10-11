package com.github.sharifyy.domain;

import com.github.sharifyy.command.SASCompanyCreateCommand;
import com.github.sharifyy.command.SelfEnterpriseCreateCommand;

import java.math.BigDecimal;
import java.util.Objects;

public class Company {
    private final TaxClassification taxClassification;
    private final SiretNumber siret;
    private final Denomination denomination;
    private final Address address;
    private AnnualTurnOver annualTurnOver;

    private Company(TaxClassification taxClassification, SiretNumber siret, Denomination denomination, Address address) {
        Objects.requireNonNull(taxClassification);
        Objects.requireNonNull(siret);
        this.taxClassification = taxClassification;
        this.siret = siret;
        this.address = address;
        this.denomination = denomination != null ? denomination : Denomination.EURO;
    }

    public static Company SAS(SASCompanyCreateCommand command) {
        return new Company(new SASClassification(), command.siret(), command.denomination(), command.address());
    }

    public static Company SelfEnterprise(SelfEnterpriseCreateCommand command) {
        return new Company(new SelfEnterpriseClassification(), command.siret(), command.denomination(), new Address.None());
    }

    public Tax tax() {
        Objects.requireNonNull(annualTurnOver);
        return taxClassification.tax(this.annualTurnOver);
    }

    public void annualTurnOver(BigDecimal value) {
        this.annualTurnOver = new AnnualTurnOver(value, this.denomination);
    }

    public SiretNumber siret() {
        return this.siret;
    }

    public AnnualTurnOver annualTurnOver() {
        return new AnnualTurnOver(this.annualTurnOver.value(), this.denomination);
    }

    public Address address() {
        return this.address;
    }
}
