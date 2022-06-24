package com.qaprosoft.carina.demo.gui.pages.hltv;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HomePageHltv extends AbstractPage {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(className = "hltv-logo-container")
    private By hltvLogo;

    @FindBy(className = "navnews")
    private By newsButton;

    @FindBy(className = "navsearchinput tt-input")
    private By navSearch;

    @FindBy(className = "navsearchicon")
    private By searchButton;

    public HomePageHltv(WebDriver driver) {
        super(driver);
    }

    public void loadPage(){
        getDriver().get("https://www.hltv.org");
    }

    public void homeButtonClick(){
        getDriver().findElement(hltvLogo).click();
    }

    public void search(String phrase){
        getDriver().findElement(navSearch).sendKeys(phrase);
        getDriver().findElement(searchButton).click();
    }


}
