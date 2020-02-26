package steps;

import pageObjects.BasePage;
import io.qameta.allure.Step;

public class BasePageSteps extends BaseStep {

    private BasePage objBP = new BasePage();

    @Step("Проверка прогрузки до конца")
    public void checkAllPageAppear() {
        objBP = new BasePage();
        objBP.checkAllPageAppear();
    }

    @Step("Ввод текста в поисковую строку")
    public void inputTextInSearchBpx(String strText) {
        objBP = new BasePage();
        objBP.inputTextInSearchBpx(strText);
    }

    @Step("Нажатие на кнопку Найти")
    public void clickButtonSearch() {
        objBP = new BasePage();
        objBP.clickButtonSearch();
    }

}