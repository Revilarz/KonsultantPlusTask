package tests;

import allure.AllureCategory;
import io.qameta.allure.Epic;
import steps.DocumentEditPageSteps;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Epic(AllureCategory.FILEEDIT_PAGE)
public class ThirdTest {

    @Story("Третий тест")//типа папка
    @DisplayName("Проверка времени загрузки документа")//название
    @Test
    public void testThirdTest() {
        DocumentEditPageSteps objDEPS = new DocumentEditPageSteps();
        objDEPS.focusOnSecondWindow();
        objDEPS.switchToFrame();
        objDEPS.waitUpdateAllPage();
        objDEPS.checkTimeLessNSeconds();
        objDEPS.focusOnSecondWindow();
    }
}
