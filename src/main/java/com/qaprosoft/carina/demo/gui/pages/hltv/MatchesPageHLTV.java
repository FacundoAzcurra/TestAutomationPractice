package com.qaprosoft.carina.demo.gui.pages.hltv;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MatchesPageHLTV extends AbstractPage {

    @FindBy(className = "hltv-logo-container")
    private ExtendedWebElement hltvLogo;

    @FindBy(xpath = "(//div[contains(@class, 'liveMatch')])[4]")
    private ExtendedWebElement closestMatch;

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    private ExtendedWebElement cookieAcceptButton;

    public MatchesPageHLTV(WebDriver driver) {
        super(driver);
    }
    public void loadPage(){
        getDriver().get("https://www.hltv.org/matches");
    }

    public void acceptCookies(){
        cookieAcceptButton.click();
    }

    public void matchSelector(){
        closestMatch.click();
    }

}
