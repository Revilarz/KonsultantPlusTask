package tests;

import steps.DocumentEditPageSteps;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class FifthTest {

    @Story("Пятый тест")//типа папка
    @DisplayName("Проверка наличия текста нк ч2 в поисковой строке")//название
    @Test
    public void testFifthTest() throws AWTException, UnsupportedFlavorException, IOException {
        DocumentEditPageSteps objDEPS = new DocumentEditPageSteps();
        objDEPS.focusOnSecondWindow();
        objDEPS.checkTextInSearchBox();
    }
}
