package com.tpg.cat.companies.application.model;

import com.tpg.cat.companies.infrastructure.persistence.TradeCategory;
import lombok.Builder;
import lombok.Value;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class TradeCategoriesModel {
    public static TradeCategoriesModel tradeCategoriesModel() {
        return CATEGORIES_MODEL;
    }

    private static final TradeCategoriesModel CATEGORIES_MODEL = new TradeCategoriesModel();

    List<TradeCategoryModel> categories;

    private TradeCategoriesModel() {
        categories = Arrays.stream(TradeCategory.values()).map(tc -> TradeCategoryModel.builder()
                    .label(tc.getName())
                    .value(tc.name())
                .build())
                .collect(Collectors.toUnmodifiableList());
    }

    @Value
    @Builder
    public static class TradeCategoryModel {
       String label;
       String value;
    }
}
