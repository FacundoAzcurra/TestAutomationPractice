package facuTesting;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.pages.hltv.HomePageHltv;
import com.qaprosoft.carina.demo.gui.pages.hltv.MatchesPageHLTV;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTestCases implements IAbstractTest {

    @Test(description = "Opens HLTV home page, accept cookies and click HLTV logo to recharge home page.")
    @MethodOwner(owner = "Facundo Azcurra")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testHomeButton(){
        HomePageHltv homePage = new HomePageHltv(getDriver());
        homePage.loadPage();
        homePage.acceptCookies();
        homePage.homeButtonClick();
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened!");
    }


    @Test(description = "Opens HLTV home page,accept cookies, clicks search button, type some phrase and search the phrase")
    @MethodOwner(owner = "Facundo Azcurra")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSearchFeature(){
        HomePageHltv homePage = new HomePageHltv(getDriver());
        homePage.loadPage();
        homePage.acceptCookies();
        homePage.search("FaZe");
        Assert.assertTrue(homePage.isUrlAsExpected("https://www.hltv.org/search?query=FaZe"));

    }

    @Test(description = "Opens HLTV home page, accept cookies and click HLTV News to go to news page.")
    @MethodOwner(owner = "Facundo Azcurra")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testNewsButton(){
        HomePageHltv homePage = new HomePageHltv(getDriver());
        homePage.loadPage();
        homePage.acceptCookies();
        homePage.newsPageClick();
        Assert.assertTrue(homePage.isPageOpened(),"News page is not opened!");
    }


    @Test(description = "Opens HLTV home page, accept cookies and log in into test account")
    @MethodOwner(owner = "Facundo Azcurra")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testUserLogin(){
        HomePageHltv homePage = new HomePageHltv(getDriver());
        homePage.loadPage();
        homePage.acceptCookies();
        homePage.loginUserPass("testfacu");
        Assert.assertTrue(homePage.isUrlAsExpected("https://www.hltv.org/"));
        }

    @Test(description = "Opens HLTV matches page, accept cookies and click the match that is about to begin or being played.")
    @MethodOwner(owner = "Facundo Azcurra")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testMatchesClick(){
        MatchesPageHLTV matchPage = new MatchesPageHLTV(getDriver());
        matchPage.loadPage();
        matchPage.acceptCookies();
        matchPage.matchSelector();
    }
}
