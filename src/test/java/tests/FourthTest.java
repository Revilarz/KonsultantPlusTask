package tests;

import steps.DocumentEditPageSteps;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class FourthTest {

    @Story("Четвертый тест")//типа папка
    @DisplayName("Проверка наличия текста налоговый кодекс и часть вторая")//название
    @Test
    public void testFourthTest() {
        DocumentEditPageSteps objDEPS = new DocumentEditPageSteps();
        objDEPS.checkTextInTitle();
        objDEPS.switchToFrame1();
        objDEPS.checkTextIsExist();
    }
}