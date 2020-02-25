package Tests;

import Steps.BasePageSteps;
import allure.AllureCategory;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Epic(AllureCategory.BASE_PAGE)
public class FirstTest {


    @Story("первый тест")//типа папка
    @DisplayName("Самый первый тест")//название
    @Test
    public void testFirstTest(){

        BasePageSteps objBPS = new BasePageSteps();
        objBPS.openLink();
        objBPS.checkAllPageAppear();
        objBPS.inputTextInSearchBpx("нк ч2");
        objBPS.clickButtonSearch();


    }
}
