package com.tpg.cat.companies.application.model;

import com.tpg.cat.companies.application.model.TradeCategoriesModel.TradeCategoryModel;
import com.tpg.cat.companies.infrastructure.persistence.TradeCategory;

public interface TradeSubCategoriesModelFixture {
    default TradeSubCategoriesModel tradeSubCategoriesModel(TradeCategory tradeCategory) {
        TradeCategoryModel tradeCategoryModel = TradeCategoryModel.builder()
                .label(tradeCategory.getName())
                .value(tradeCategory.name())
            .build();


        TradeSubCategoriesModel tradeSubCategoriesModel = new TradeSubCategoriesModel.TradeSubCategoriesModelBuilder()
                .tradeSubCategories()
            .build();

        return null;
    }
}
