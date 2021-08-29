package com.tpg.cat.companies.infrastructure.persistence;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TradeCategory extends TradeCategoryDetails {

    private List<TradeSubCategory> tradeSubCategories;
}
