package steps;

import pageObjects.DocumentEditPage;
import io.qameta.allure.Step;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.ParseException;

public class DocumentEditPageSteps {
    private DocumentEditPage objDEP = new DocumentEditPage();

    @Step("Фокусировка на второй вкладке")
    public void focusOnSecondWindow() {
        objDEP = new DocumentEditPage();
        objDEP.focusOnSecondWindow();
    }

    @Step("Ожиание прогрузки страницы")
    public void waitUpdateAllPage() {
        objDEP = new DocumentEditPage();
        objDEP.waitUpdateAllPage();
    }

    @Step("Проверка того что время загрузки  страницы меньше указанного в свойствах времени")
    public void checkTimeLessNSeconds() {
        objDEP = new DocumentEditPage();
        objDEP.checkTimeLessNSeconds();
    }

    @Step("Проверка текста в названии вкладки")
    public void checkTextInTitle() {
        objDEP = new DocumentEditPage();
        objDEP.checkTextInTitle();
    }

    @Step("Проверка наличия текста нк ч2  поисковой строке")
    public void checkTextInSearchBox() throws AWTException, UnsupportedFlavorException, IOException {
        objDEP = new DocumentEditPage();
        objDEP.checkTextInSearchBox();
    }

    @Step("Переключение на фрэйм")
    public void switchToFrame() {
        objDEP = new DocumentEditPage();
        objDEP.switchToFrame();
    }


    @Step("Проверка заголовков документа на соответствие")
    public void checkTextIsExist() {
        objDEP = new DocumentEditPage();
        objDEP.checkTitlesOfDocument();
    }

    @Step("Нажатие на кнопку Оглавление")
    public void clickContents() {
        objDEP = new DocumentEditPage();
        objDEP.clickContents();
    }

    @Step("Ввод текста в поисковую строку Оглавления")
    public void inputTextInSearchBox2(String strText) {
        objDEP = new DocumentEditPage();
        objDEP.inputTextInSearchBox2(strText);
    }

    @Step("Нажатие на кнопку Найти в Оглавлении")
    public void clickSearchButton() {
        objDEP = new DocumentEditPage();
        objDEP.clickSearchButton();
    }

    @Step("Нажатие на первый искомый результат")
    public void clickOnHeader() {
        objDEP = new DocumentEditPage();
        objDEP.clickOnHeader();
    }

    @Step("Выделение текста для печати и помещение в буфер")
    public void selectText() throws UnsupportedFlavorException, IOException {
        objDEP = new DocumentEditPage();
        objDEP.selectText();
    }

    @Step("Нажатие на кнопку печати")
    public void clickPrint() {
        objDEP = new DocumentEditPage();
        objDEP.clickPrint();
    }

    @Step("Переключение не окно печати")
    public void switchOnPrintWindow() throws AWTException {
        objDEP = new DocumentEditPage();
        objDEP.switchOnPrintWindow();
    }

    @Step("Нажатие на кнопку Редакции")
    public void clickRedaction() {
        objDEP = new DocumentEditPage();
        objDEP.clickRedaction();
    }

    @Step("Проверка наличия редакций не вступивших в силу")
    public void checkEditions() {
        objDEP = new DocumentEditPage();
        objDEP.checkEditions();
    }

    @Step("Проверка дат")
    public void checkAndPrintDate() throws ParseException {
        objDEP = new DocumentEditPage();
        objDEP.checkAndPrintDate();
    }

}