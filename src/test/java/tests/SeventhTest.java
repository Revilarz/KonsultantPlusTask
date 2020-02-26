package tests;

import steps.DocumentEditPageSteps;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class SeventhTest {
    @Story("Седьмой тест")//типа папка
    @DisplayName("Выделение текста и проверка корректнйо печати")//название
    @Test
    public void testSeventhTest() throws AWTException, UnsupportedFlavorException, IOException {
        DocumentEditPageSteps objDEPS = new DocumentEditPageSteps();
        objDEPS.switchToFrame1();
        objDEPS.selectText();
        objDEPS.clickPrint();

    }
}
