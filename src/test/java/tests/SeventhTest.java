package tests;

import allure.AllureCategory;
import io.qameta.allure.Epic;
import steps.DocumentEditPageSteps;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

@Epic(AllureCategory.FILEEDIT_PAGE)
public class SeventhTest {

    @Story("Седьмой тест")//типа папка
    @DisplayName("Выделение текста и нажатие кнопки печати")//название
    @Test
    public void testSeventhTest() throws UnsupportedFlavorException, IOException {
        DocumentEditPageSteps objDEPS = new DocumentEditPageSteps();
        objDEPS.switchToFrame1();
        objDEPS.selectText();
        objDEPS.clickPrint();

    }
}
