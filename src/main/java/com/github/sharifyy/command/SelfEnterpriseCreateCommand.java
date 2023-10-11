package com.github.sharifyy.command;

import com.github.sharifyy.domain.Denomination;
import com.github.sharifyy.domain.SiretNumber;

public record SelfEnterpriseCreateCommand(
        SiretNumber siret,
        Denomination denomination) {
}
