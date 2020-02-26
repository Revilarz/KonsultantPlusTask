package tests;

import allure.AllureCategory;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import steps.DocumentEditPageSteps;

@Epic(AllureCategory.FILEEDIT_PAGE)
public class NinthTest {
    @Story("Девятый тест")//типа папка
    @DisplayName("Проверка проверка наличия редакций не вступивших в силу")//название
    @Test
    public void testNinthTest() {
        DocumentEditPageSteps objDEPS = new DocumentEditPageSteps();
        objDEPS.clickRedaction();
        objDEPS.checkEditions();
    }
}
