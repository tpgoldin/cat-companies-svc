package com.tpg.cat.companies.application;

import org.junit.jupiter.api.Test;

import static com.tpg.cat.companies.application.model.TradeCategoriesModel.tradeCategoriesModel;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class HomeAccessIT extends WebAccessIT {
    @Test
    public void givenUserWantsToLookForTradesPerson_whenAccessingHome_thenHomePageIsDisplayed() throws Exception {
        mockMvc.perform(get("/checkatrade/home")
                        .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("tradeCategories", tradeCategoriesModel().getCategories()));
    }
}
