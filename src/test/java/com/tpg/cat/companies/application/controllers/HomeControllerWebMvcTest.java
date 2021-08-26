package com.tpg.cat.companies.application.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static com.tpg.cat.companies.application.model.TradeCategoriesModel.tradeCategoriesModel;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = HomeController.class)
@ActiveProfiles("dev")
public class HomeControllerWebMvcTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void givenUserWantsToLookForTradesPerson_whenAccessingHome_thenHomePageIsDisplayed() throws Exception {
        mockMvc.perform(get("/checkatrade/home"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("tradeCategories", tradeCategoriesModel().getCategories()));
    }
}