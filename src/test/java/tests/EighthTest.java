package tests;

import allure.AllureCategory;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import steps.DocumentEditPageSteps;

@Epic(AllureCategory.FILEEDIT_PAGE)
public class EighthTest {

    @Story("Восьмой тест")//типа папка
    @DisplayName("Проверка корректнйо печати")//название
    @Test
    public void testEighthTest() {
        DocumentEditPageSteps objDEPS = new DocumentEditPageSteps();
        objDEPS.switchOnPrintWindow();

    }
}
