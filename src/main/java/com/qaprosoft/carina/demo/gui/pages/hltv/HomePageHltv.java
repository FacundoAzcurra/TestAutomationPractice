package com.qaprosoft.carina.demo.gui.pages.hltv;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HomePageHltv extends AbstractPage {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    private ExtendedWebElement cookieAcceptButton;

    @FindBy(xpath = "//*[@id=\"loginpopup\"]/form/button")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//*[@id=\"loginpopup\"]/form/input[1]")
    private ExtendedWebElement usernameButton;

    @FindBy(xpath = "//*[@id=\"loginpopup\"]/form/input[2]")
    private ExtendedWebElement passwordButton;

    @FindBy(className = "navsignin")
    private ExtendedWebElement signInButton;

    @FindBy(className = "hltv-logo-container")
    private ExtendedWebElement hltvLogo;

    @FindBy(className = "navnews")
    private ExtendedWebElement newsButton;

    @FindBy(name = "query")
    private ExtendedWebElement navSearch;

    @FindBy(className = "navsearchicon")
    private ExtendedWebElement searchButton;

    public HomePageHltv(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        cookieAcceptButton.click();
    }

    public void loadPage() {
        getDriver().get("https://www.hltv.org");
    }

    public void homeButtonClick() {
        hltvLogo.click();
    }

    public void loginUserPass(String phrase) {
        signInButton.click();
        usernameButton.type(phrase);
        passwordButton.type(phrase);
        loginButton.click();
    }

    public void search(String phrase) {
        navSearch.click();
        navSearch.type(phrase);
        searchButton.click();
    }

    public void newsPageClick() {
        newsButton.click();
    }

    public void searchWithDp(String phrase) {
        navSearch.click();
        navSearch.type(phrase);
        searchButton.click();
    }


    public void loginWithDP(String user, String pass) {
        signInButton.click();
        usernameButton.type(user);
        passwordButton.type(pass);
        loginButton.click();
    }

}
