package Tests;

import Steps.DocumentEditPageSteps;
import Steps.SearchResultsPageSteps;
import org.junit.Test;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class SecondTest {

    @Test
    public void testSecondTest() throws AWTException, UnsupportedFlavorException, IOException {
        FirstTest.testFirstTest();
        SearchResultsPageSteps objSRPS = new SearchResultsPageSteps();
        objSRPS.clickFirstRow();

        DocumentEditPageSteps objDEPS = new DocumentEditPageSteps();
        objDEPS.focusOnSecondWindow();
        objDEPS.waitUpdateAllPage();
        objDEPS.checkTimeLess10Seconds();
        objDEPS.checkTextInSearchBox();
        objDEPS.checkTextInTitle();
        objDEPS.checkTextIsExist();
    }
}
