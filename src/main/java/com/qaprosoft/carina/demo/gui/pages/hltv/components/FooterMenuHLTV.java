package com.qaprosoft.carina.demo.gui.pages.hltv.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FooterMenuHLTV extends AbstractUIObject {

    @FindBy(xpath = "//a[@href='/major']")
    private ExtendedWebElement majorButton;

    @FindBy(xpath = "//a[@href='/contact#tab-applyForJobSection']")
    private ExtendedWebElement jobsButton;

    @FindBy(xpath = "//a[@href='/contact']")
    private ExtendedWebElement contactButton;

    @FindBy(xpath = "//a[@href='https://www.twitter.com/HLTVorg']")
    private ExtendedWebElement twitterButton;



    public FooterMenuHLTV(WebDriver driver) {
        super(driver);
    }

    public void majorButtonClick(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        majorButton.click();
    }

    public void contactButtonClick(){
        contactButton.click();
    }

    public void jobsButtonClick(){
        jobsButton.click();
    }

    public void twitterButtonClick(){
        twitterButton.click();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}
