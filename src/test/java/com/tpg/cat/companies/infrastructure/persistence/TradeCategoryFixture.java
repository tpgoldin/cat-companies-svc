package com.tpg.cat.companies.infrastructure.persistence;

public interface TradeCategoryFixture {
    default TradeCategory tradeCategory(Long id, String name) {
        TradeCategory entity = new TradeCategory();
        entity.setTradeCategoryId(id);
        entity.setName(name);
        return entity;
    }
}
