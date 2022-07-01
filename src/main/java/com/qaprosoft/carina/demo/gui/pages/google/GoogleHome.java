package com.qaprosoft.carina.demo.gui.pages.google;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class GoogleHome extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//div[@class='CqAVzb lJ9FBc']//input[@name='btnK']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//img[@alt='Google']")
    private ExtendedWebElement googleLogo;

    @FindBy(xpath = "//*[name()='path' and contains(@d,'M6,8c1.1,0')]")
    private ExtendedWebElement googleApps;

    @FindBy(xpath = "//a[@href='https://www.youtube.com/?gl=AR']//div[@class='CgwTDb']//span[@class='MrEfLc']")
    private ExtendedWebElement youtubeGoogleApps;

    @FindBy(xpath = "//input[@id='search']")
    private ExtendedWebElement youtubeSearchBar;

    @FindBy(xpath = "//button[@id='search-icon-legacy']//yt-icon[@class='style-scope ytd-searchbox']")
    private ExtendedWebElement youtubeSearchButton;

    @FindBy(xpath = "//body/ytd-app/div[@id='content']/ytd-page-manager[@id='page-manager']/ytd-search[@role='main']/div[@id='container']/ytd-two-column-search-results-renderer[@class='style-scope ytd-search']/div[@id='primary']/ytd-section-list-renderer[@class='style-scope ytd-two-column-search-results-renderer']/div[@id='contents']/ytd-item-section-renderer[@class='style-scope ytd-section-list-renderer']/div[@id='contents']/ytd-video-renderer[1]/div[1]")
    private ExtendedWebElement youtubeFirst;

    public GoogleHome(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        getDriver().get("https://www.google.com");
    }

    public void clickGoogleLogo() {
        googleLogo.click();
    }

    public void googleApps() {
        driver.navigate().to("youtube.com");
        youtubeSearchBar.type("Rick Astley - Never gonna give you up");
        youtubeSearchButton.click();
        youtubeFirst.click();
        try {
            driver.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void searchWithDp(String phrase) {
        searchBar.click();
        searchBar.type(phrase);
        searchButton.click();
    }

}
