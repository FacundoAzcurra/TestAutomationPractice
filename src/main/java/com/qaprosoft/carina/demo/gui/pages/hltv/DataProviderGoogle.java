package com.qaprosoft.carina.demo.gui.pages.hltv;

import org.testng.annotations.DataProvider;

public class DataProviderGoogle {
    public DataProviderGoogle() {
    }

    @DataProvider(name = "items")
    public Object[][] searchData(){
        Object[][]data ={{"SOLVD"},{"Zebrunner"},{"Carina"},{"TestNG"},{"myBatis"}};
        return data;
    }
}
