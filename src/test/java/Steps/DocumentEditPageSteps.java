package Steps;

import PageObjects.DocumentEditPage;
import io.qameta.allure.Step;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class DocumentEditPageSteps {
    private DocumentEditPage objDEP = new DocumentEditPage();

    public void focusOnSecondWindow(){
        objDEP = new DocumentEditPage();
        objDEP.focusOnSecondWindow();
    }

    public void waitUpdateAllPage(){
        objDEP = new DocumentEditPage();
        objDEP.waitUpdateAllPage();
    }

    public void checkTimeLess10Seconds(){
        objDEP = new DocumentEditPage();
        objDEP.checkTimeLess10Seconds();
    }

    public void checkTextInTitle(){
        objDEP = new DocumentEditPage();
        objDEP.checkTextInTitle();
    }

    @Step("Проверка наличия текста нк ч2  поисковой строке")
    public void checkTextInSearchBox() throws AWTException, UnsupportedFlavorException, IOException {
        objDEP = new DocumentEditPage();
        objDEP.checkTextInSearchBox();
    }

    public void checkTextIsExist(){
        objDEP = new DocumentEditPage();
        objDEP.checkTextIsExist();
    }
}
