package com.qaprosoft.carina.demo.gui.pages.hltv;

import org.testng.annotations.DataProvider;

public class DataProviderHLTV {

    public DataProviderHLTV() {
        //Empty constructor
    }

    @DataProvider(name = "userpass")
    public Object[][] loginData() {
        Object[][] data = {{"testfacu", "testfacu"}};
        return data;
    }


    @DataProvider(name = "searcher")
    public Object[][] search() {
        Object[][] data = {{"9z"}, {"FaZe"}, {"Cloud9"}, {"Heroic"}, {"Isurus"}, {"BIG"}};
        return data;
    }


}
