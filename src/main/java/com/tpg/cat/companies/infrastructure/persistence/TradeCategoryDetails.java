package com.tpg.cat.companies.infrastructure.persistence;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class TradeCategoryDetails {
    private long tradeCategoryId;
    private String name;
}
