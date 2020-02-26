package tests;

import steps.DocumentEditPageSteps;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class ThirdTest {

    @Story("Третий тест")//типа папка
    @DisplayName("Проверка времени загрузки документа")//название
    @Test
    public void testThirdTest() {
        DocumentEditPageSteps objDEPS = new DocumentEditPageSteps();
        objDEPS.focusOnSecondWindow();
        objDEPS.switchToFrame1();
        objDEPS.waitUpdateAllPage();
        objDEPS.checkTimeLess10Seconds();
        objDEPS.focusOnSecondWindow();
    }
}
