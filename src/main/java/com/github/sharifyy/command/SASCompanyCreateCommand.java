package com.github.sharifyy.command;

import com.github.sharifyy.domain.Address;
import com.github.sharifyy.domain.Denomination;
import com.github.sharifyy.domain.SiretNumber;

public record SASCompanyCreateCommand(
        SiretNumber siret,
        Denomination denomination,
        Address.RegisteredAddress address
) {
}
