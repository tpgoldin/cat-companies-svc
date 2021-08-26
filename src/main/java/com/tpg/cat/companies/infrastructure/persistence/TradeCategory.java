package com.tpg.cat.companies.infrastructure.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TradeCategory {
    BUILDER("Builder"), ELECTRICIAN("Electrician"), PLUMBER("Plumber"), ROOFER("Roofer");

    private final String name;
}
