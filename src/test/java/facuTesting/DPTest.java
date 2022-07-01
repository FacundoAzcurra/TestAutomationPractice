package facuTesting;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.google.GoogleHome;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DPTest implements IAbstractTest {
    @Test(dataProvider = "DataProvider")
    @TestRailCases(testCasesId = "1")
    @XlsDataSourceParameters(path = "xls/facu.xlsx", sheet = "1", dsUid = "TUID", testRailColumn = "a")
    @MethodOwner(owner = "FacundoAzcurra")
    public void testGoogleDPExcel(HashMap<String, String> data) {
        GoogleHome gogHome = new GoogleHome(getDriver());
        gogHome.loadPage();
        gogHome.searchWithDp(data.get("a"));
    }
}