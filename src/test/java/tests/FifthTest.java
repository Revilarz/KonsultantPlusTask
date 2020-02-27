package tests;

import allure.AllureCategory;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import steps.DocumentEditPageSteps;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Epic(AllureCategory.FILEEDIT_PAGE)
public class FifthTest {

    @Story("Пятый тест")//типа папка
    @DisplayName("Проверка наличия текста нк ч2 в поисковой строке")//название
    @Flaky //нестабильный тест, может упать из-за того что в буфере что то есть (думаю при запуске в контейнере/удаленном серве проблема должна уйти)
    @Test
    public void testFifthTest() {
        DocumentEditPageSteps objDEPS = new DocumentEditPageSteps();
        objDEPS.focusOnSecondWindow();
        objDEPS.checkTextInSearchBox();
    }
}