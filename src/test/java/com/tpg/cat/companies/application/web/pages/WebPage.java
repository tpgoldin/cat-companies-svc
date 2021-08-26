package com.tpg.cat.companies.application.web.pages;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@RequiredArgsConstructor
public abstract class WebPage {
    protected WebDriver webDriver;

    protected WebPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected WebElement findElementById(String id) {
        return webDriver.findElement(By.id(id));
    }

    protected WebElement findElementByCssSelector(String value) {
        return webDriver.findElement(By.cssSelector(value));
    }

    protected WebElement findElementByName(String name) {
        return webDriver.findElement(By.name(name));
    }
}
