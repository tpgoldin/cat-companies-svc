package com.tpg.cat.companies.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tpg.cat.companies.application.model.TradeCategoriesModel;
import com.tpg.cat.companies.application.model.TradeSubCategoriesModel;
import com.tpg.cat.companies.infrastructure.persistence.TradeCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static com.tpg.cat.companies.application.model.TradeCategoriesModel.tradeCategoriesModel;
import static com.tpg.cat.companies.application.model.TradeSubCategoriesModel.tradeSubCategoriesModel;
import static com.tpg.cat.companies.infrastructure.persistence.TradeCategory.AIR_CONDITIONING;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = TradesQueryController.class)
public class TradesQueryControllerWebMvcTest extends ControllerWebMvcTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenCustomerWantsToSearchForATrade_whenSearchingForATrade_thenSearchResultsAreDisplayed() throws Exception {
        TradeSearchRequest searchRequest = new TradeSearchRequest();
        searchRequest.setTrade(AIR_CONDITIONING.name());
        searchRequest.setPostCode("CR0 6DG");

        TradeCategory tradeCategory = new TradeCategory();

        TradeSubCategoriesModel tradeSubCategoriesModel = tradeSubCategoriesModel();

        mockMvc.perform(post("/checkatrade/tradeSearch"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("tradeSearchResults"))
                .andExpect(model().attribute("tradeSearchRequest", searchRequest))
                .andExpect(model().attribute("tradeRefine", tradeRefine))
                .andExpect(model().attribute("tradeCategories", tradeCategoriesModel().getCategories()));
    }
}
