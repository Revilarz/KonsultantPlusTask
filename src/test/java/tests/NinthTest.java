package tests;

import allure.AllureCategory;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import steps.BasePageSteps;
import steps.DocumentEditPageSteps;
import steps.SearchResultsPageSteps;

@Epic(AllureCategory.FILEEDIT_PAGE)
public class NinthTest {
    @Story("Девятый тест")//типа папка
    @DisplayName("Проверка проверка наличия редакций не вступивших в силу")//название
    @Test
    public void testNinthTest() {
        BasePageSteps objBPS = new BasePageSteps();
        objBPS.openLink();
        objBPS.checkAllPageAppear();
        objBPS.inputTextInSearchBpx("нк ч2");
        objBPS.clickButtonSearch();

        SearchResultsPageSteps objSRPS = new SearchResultsPageSteps();
        objSRPS.clickFirstRow();

        DocumentEditPageSteps objDEPS = new DocumentEditPageSteps();
        objDEPS.focusOnSecondWindow();
        objDEPS.clickRedaction();
        objDEPS.checkEditions();
    }
}