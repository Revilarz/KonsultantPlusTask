package pageObjects;

import org.junit.Assert;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    /**
     * проверка прогрузки до конца
     */
    public void checkAllPageAppear(){
        Assert.assertTrue($(byText("contact@consultant.ru")).isDisplayed());
    }

    /**
     * кладем текст в поисковую строку
     */
    public void inputTextInSearchBpx(String strText){
        $(byId("dictFilter")).val(strText);
    }

    /**
     * нажимаем на кнопку Найти
     */
    public void clickButtonSearch(){
        $(byAttribute("class","doSearchBtn flat")).click();
    }

}