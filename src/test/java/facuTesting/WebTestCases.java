package facuTesting;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.google.GoogleHome;
import com.qaprosoft.carina.demo.gui.pages.google.DataProviderGoogle;
import com.qaprosoft.carina.demo.gui.pages.hltv.DataProviderHLTV;
import com.qaprosoft.carina.demo.gui.pages.hltv.HomePageHltv;
import com.qaprosoft.carina.demo.gui.pages.hltv.MatchesPageHLTV;
import com.qaprosoft.carina.demo.gui.pages.hltv.components.FooterMenuHLTV;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WebTestCases implements IAbstractTest {

    @Test(description = "Opens HLTV home page, accept cookies and click HLTV logo to recharge home page.")
    @MethodOwner(owner = "FacundoAzcurra")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testHomeButton(){
        HomePageHltv homePage = new HomePageHltv(getDriver());
        homePage.loadPage();
        homePage.acceptCookies();
        homePage.homeButtonClick();
        Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened!");
    }


    @Test(description = "Opens HLTV home page,accept cookies, clicks search button, type some phrase and search the phrase")
    @MethodOwner(owner = "FacundoAzcurra")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSearchFeature(){
        HomePageHltv homePage = new HomePageHltv(getDriver());
        homePage.loadPage();
        homePage.acceptCookies();
        homePage.search("FaZe");
        Assert.assertTrue(homePage.isUrlAsExpected("https://www.hltv.org/search?query=FaZe"));

    }


    @Test(description = "Opens HLTV home page, accept cookies and click HLTV News to go to news page.")
    @MethodOwner(owner = "FacundoAzcurra")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testNewsButton(){
        HomePageHltv homePage = new HomePageHltv(getDriver());
        homePage.loadPage();
        homePage.acceptCookies();
        homePage.newsPageClick();
        Assert.assertTrue(homePage.isPageOpened(),"News page is not opened!");
    }


    @Test(description = "Opens HLTV home page, accept cookies and log in into test account")
    @MethodOwner(owner = "FacundoAzcurra")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testUserLogin(){
        HomePageHltv homePage = new HomePageHltv(getDriver());
        homePage.loadPage();
        homePage.acceptCookies();
        homePage.loginUserPass("testfacu");
        Assert.assertTrue(homePage.isUrlAsExpected("https://www.hltv.org/"));
        }

    @Test(description = "Opens HLTV matches page, accept cookies and click the match that is about to begin or being played.")
    @MethodOwner(owner = "FacundoAzcurra")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testMatchesClick(){
        MatchesPageHLTV matchPage = new MatchesPageHLTV(getDriver());
        matchPage.loadPage();
        matchPage.acceptCookies();
        matchPage.matchSelector();
    }


    @Test(description = "Load home page, click on login manager, log in test account with data provider method.",dataProvider = "userpass",dataProviderClass = DataProviderHLTV.class)
    @MethodOwner(owner = "FacundoAzcurra")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void loginTestDP(String user, String pass){
        HomePageHltv homePage = new HomePageHltv(getDriver());
        homePage.loadPage();
        homePage.acceptCookies();
        homePage.loginWithDP(user,pass);
    }

    @Test(description = "Load home page, clicks on search bar, search a team.",dataProvider = "searcher",dataProviderClass = DataProviderHLTV.class)
    @MethodOwner(owner = "FacundoAzcurra")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void searchTestDP(String phrase){
        HomePageHltv homePage = new HomePageHltv(getDriver());
        homePage.loadPage();
        homePage.acceptCookies();
        homePage.searchWithDp(phrase);
    }

    @Test(description = "google search with many things.",dataProvider = "items",dataProviderClass = DataProviderGoogle.class)
    @MethodOwner(owner = "FacundoAzcurra")
    public void searchGoogleDP(String phrase){
        GoogleHome gogHome = new GoogleHome(getDriver());
        gogHome.loadPage();
        gogHome.searchWithDp(phrase);
    }

    @Test(description = "Testing UI Components with footer menu links.")
    @MethodOwner(owner = "FacundoAzcurra")
    public void testFooterMenu(){
        HomePageHltv homePage = new HomePageHltv(getDriver());
        FooterMenuHLTV footerMenu = new FooterMenuHLTV(getDriver());
        homePage.loadPage();
        homePage.acceptCookies();
        footerMenu.contactButtonClick();
        Assert.assertTrue(footerMenu.isUrlAsExpected("https://www.hltv.org/contact"));
        footerMenu.jobsButtonClick();
        Assert.assertTrue(footerMenu.isUrlAsExpected("https://www.hltv.org/contact#tab-applyForJobSection"));
        footerMenu.twitterButtonClick();
        Assert.assertTrue(footerMenu.isUrlAsExpected("https://twitter.com/HLTVorg"));
        footerMenu.majorButtonClick();
        Assert.assertTrue(footerMenu.isUrlAsExpected("https://www.hltv.org/major"));
    }

}
