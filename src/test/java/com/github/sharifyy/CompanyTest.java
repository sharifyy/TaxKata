package com.github.sharifyy;

import com.github.sharifyy.command.SASCompanyCreateCommand;
import com.github.sharifyy.command.SelfEnterpriseCreateCommand;
import com.github.sharifyy.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CompanyTest {

    @Test
    void testSelfEnterpriseCompanyTax(){
        // given
        var command = new SelfEnterpriseCreateCommand(
                new SiretNumber("12345678912340"),
                Denomination.EURO);
        Company enterprise = Company.SelfEnterprise(command);

        // when
        enterprise.annualTurnOver(new BigDecimal("100"));

        // then
        Assertions.assertThat(enterprise.tax()).isEqualTo(new Tax(new BigDecimal("25.00"), Denomination.EURO));
    }

    @Test
    void testSaaSCompanyTax(){
        // given
        var command = new SASCompanyCreateCommand(
                new SiretNumber("12345678912340"),
                Denomination.EURO,
                new Address.RegisteredAddress(new City("Paris"), new Street("some street"), "123"));
        Company saas = Company.SAS(command);

        // when
        saas.annualTurnOver(new BigDecimal("100"));


        // then
        Assertions.assertThat(saas.tax()).isEqualTo(new Tax(new BigDecimal("33.00"), Denomination.EURO));
    }
}