package com.tpg.cat.companies.application.model;

import com.tpg.cat.companies.infrastructure.persistence.TradeCategory;
import lombok.Builder;
import lombok.Value;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;

@Value
public class TradeCategoriesModel {
    public static TradeCategoriesModel tradeCategoriesModel(List<TradeCategory> tradeCategories) {
        return new TradeCategoriesModel(tradeCategories);
    }

    static TradeCategoryModel from(TradeCategory value) {
        return TradeCategoryModel.builder()
                .label(value.getName())
                .value(Long.toString(value.getTradeCategoryId()))
            .build();
    }

    List<TradeCategoryModel> categories;

    private TradeCategoriesModel(List<TradeCategory> values) {
        categories = values.stream().map(TradeCategoriesModel::from).collect(toUnmodifiableList());
    }

    @Value
    @Builder
    public static class TradeCategoryModel {
       String label;
       String value;
    }
}
