package facuTesting;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carina.demo.gui.pages.google.GoogleHome;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DPTest implements IAbstractTest {
    @Test(dataProvider = "DataProvider")
    @TestRailCases(testCasesId = "1")
    @XlsDataSourceParameters(path = "xls/facu.xlsx", sheet = "1", dsUid = "TUID", testRailColumn = "a")
    public void testGoogleDPExcel(HashMap<String, String> args){
        GoogleHome gogHome = new GoogleHome(getDriver());
        gogHome.loadPage();
        gogHome.searchWithDp(args.get("a"));
    }
}
