package com.tpg.cat.companies.application.controller;

import com.tpg.cat.companies.application.model.TradeCategoriesModel;
import com.tpg.cat.companies.application.model.TradeCategoriesModel.TradeCategoryModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.tpg.cat.companies.application.model.TradeCategoriesModel.tradeCategoriesModel;
import static com.tpg.cat.companies.application.view.Views.HOME_VIEW;

@Controller
@RequestMapping("/checkatrade")
@Slf4j
public class HomeController {
    private final TradeCategoriesModel tradeCategoriesModel = tradeCategoriesModel();

    @ModelAttribute("tradeCategories")
    public List<TradeCategoryModel> getTradeCategories() { return tradeCategoriesModel.getCategories(); }

    @GetMapping(value = "/home")
    public String loadHomePage() {
        return HOME_VIEW;
    }
}
