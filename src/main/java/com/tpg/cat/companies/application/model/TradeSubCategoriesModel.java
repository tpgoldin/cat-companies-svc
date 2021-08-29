package com.tpg.cat.companies.application.model;

import com.tpg.cat.companies.application.model.TradeCategoriesModel.TradeCategoryModel;
import com.tpg.cat.companies.infrastructure.persistence.TradeCategory;
import com.tpg.cat.companies.infrastructure.persistence.TradeSubCategory;
import lombok.Value;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

@Value
public class TradeSubCategoriesModel {
    public static TradeSubCategoriesModel tradeSubCategoriesModel(TradeCategory tradeCategory) {
        return new TradeSubCategoriesModel(tradeCategory, tradeCategory.getTradeSubCategories());
    }

    private static TradeCategoryModel from(TradeSubCategory value) {
        return TradeCategoryModel.builder()
                .label(value.getName())
                .value(Long.toString(value.getTradeCategoryId()))
            .build();
    }

    TradeCategoryModel tradeCategoryModel;
    List<TradeCategoryModel> tradeSubCategoriesModels;

    private TradeSubCategoriesModel(TradeCategory tradeCategory, List<TradeSubCategory> subCategories) {
        tradeCategoryModel = TradeCategoriesModel.from(tradeCategory);
        tradeSubCategoriesModels = subCategories.stream().map(TradeSubCategoriesModel::from).collect(toUnmodifiableList());
    }
}
