package com.tpg.cat.companies.application.web.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@Getter
public class HomePage extends WebPage {
    private static final String HOME_URL = "http://localhost:8081/checkatrade/home";

    private Select tradeCategorySelector;

    public HomePage(WebDriver webDriver) {
        super(webDriver);

        webDriver.get(HOME_URL);

        tradeCategorySelector = new Select(findElementById("trade-category-selector"));
    }
}
