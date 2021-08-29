package com.tpg.cat.companies.application.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static com.tpg.cat.companies.application.model.TradeCategoriesModel.tradeCategoriesModel;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = HomeController.class)
public class HomeControllerWebMvcTest extends ControllerWebMvcTest {

    @Test
    public void givenUserWantsToLookForTradesPerson_whenAccessingHome_thenHomePageIsDisplayed() throws Exception {
        mockMvc.perform(get("/checkatrade/home"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("tradeCategories", tradeCategoriesModel().getCategories()));
    }
}