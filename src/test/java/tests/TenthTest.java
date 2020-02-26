package tests;

import allure.AllureCategory;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import steps.DocumentEditPageSteps;

import java.text.ParseException;

@Epic(AllureCategory.FILEEDIT_PAGE)
public class TenthTest {
    @Story("Десятый тест")//типа папка
    @DisplayName("Проверка дат")//название
    @Test
    public void testTenthTest() throws ParseException {
        DocumentEditPageSteps objDEPS = new DocumentEditPageSteps();
        objDEPS.checkAndPrintDate();
    }
}
