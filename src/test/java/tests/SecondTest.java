package tests;

import allure.AllureCategory;
import io.qameta.allure.Epic;
import steps.SearchResultsPageSteps;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Epic(AllureCategory.SEARCH_PAGE)
public class SecondTest {

    @Story("Второй тест")//типа папка
    @DisplayName("Открытие первого докумена по результатм поиска")//название
    @Test
    public void testSecondTest() {

        SearchResultsPageSteps objSRPS = new SearchResultsPageSteps();
        objSRPS.clickFirstRow();
    }
}