package pageObjects;

import steps.BaseStep;
import com.codeborne.selenide.Condition;
import org.junit.Assert;
import utils.GetProperties;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class DocumentEditPage {

    public static int finishTime;


    /**
     * фокусировка на втором окне
     */
    public void focusOnSecondWindow() {
        switchTo().window(1);
        switchTo().defaultContent();
    }

    /**
     * ожидание прогрузки стрницы
     */
    public void waitUpdateAllPage() {
        $(byText("НАЛОГОВЫЙ")).waitUntil(Condition.visible, 15000);
        //$(byClassName("print")).waitUntil(Condition.appear, 20000);
        finishTime = BaseStep.getHours() * 360 + BaseStep.getMinutes() * 60 + BaseStep.getSeconds();
    }

    /**
     * проверка что время прогрузки меньше 10 сек
     */
    public void checkTimeLess10Seconds() {
        System.out.println("result = " + (finishTime - SearchResultPage.startTime));
        Assert.assertTrue(finishTime - SearchResultPage.startTime < Integer.parseInt(GetProperties.getPropertiesByText("timeout")));
    }


    /**
     * Проверка что в названии вкалдки содержатся фразы - налоговый кодекс и часть вторая
     */
    public void checkTextInTitle() {
        Assert.assertTrue(title().toLowerCase().contains("налоговый кодекс") & title().toLowerCase().contains("часть вторая"));
    }

    /**
     * без робота и считывания из буфера не знал как еще вытащить текст из Поисковой строки для сравнения
     */
    public void checkTextInSearchBox() throws AWTException, IOException, UnsupportedFlavorException {
        $(byId("dictFilter")).click();
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);

        //залипала Ctrl
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor dataFlavor = DataFlavor.stringFlavor;
        String text = "";
        if (systemClipboard.isDataFlavorAvailable(dataFlavor)) {
            text = (String) systemClipboard.getData(dataFlavor);
        }
        //System.out.println("Текст из буфера - "+text);
        Assert.assertEquals(text, "нк ч2");
    }


    /**
     * переключение на фрейм
     */
    public void switchToFrame1() {
        switchTo().frame(1);
    }

    /**
     * проверка заголовков в фале
     */
    public void checkTitlesOfDocument() {
        Assert.assertEquals($(byId("segm1")).getText().toLowerCase(), "налоговый");
        Assert.assertEquals($$(byId("segm1")).get(1).getText().toLowerCase(), "кодекс");
        Assert.assertEquals($$(byId("segm1")).get(2).getText().toLowerCase(), "часть");
        Assert.assertEquals($$(byId("segm1")).get(3).getText().toLowerCase(), "вторая");
    }

    /**
     * нажатие на кнопку Оглавление
     */
    public void clickContents() {
        $(byClassName("contents")).click();
    }

    /**
     * ввод текста в поисковую строку
     */
    public void inputTextInSearchBox2(String strText) {
        $(byId("page2")).$(byName("dictFilter")).val(strText);
    }

    /**
     * нажать на кнопку Найти
     */
    public void clickSearchButton() {
        $(byId("searchFindBtn")).click();
    }

    /**
     * нажать на пункт оглавления для перехода
     */
    public void clickOnHeader() {
        $(byId("segm1")).click();
    }

    public String text1 = "";

    /**
     * выделяю текст (читерским способом) и сохраняю в переменную через буер для дальнейшего сравнения
     */
    public void selectText() throws IOException, UnsupportedFlavorException {
        $(byId("p1562")).dragAndDropTo($(byId("p1567")));
        $(byId("p1567")).contextClick();

        switchTo().defaultContent();
        $(byClassName("contextMenuItem")).$(withText("Копировать")).click();

        Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor dataFlavor = DataFlavor.stringFlavor;
        if (systemClipboard.isDataFlavorAvailable(dataFlavor)) {
            text1 = (String) systemClipboard.getData(dataFlavor);
        }

        System.out.println(text1);
        //можно через координаты но мой метод быстрее пока dragAndDropTo работает криво)
        /*System.out.println("Коордтинаты 1563 - "+$(byId("p1563")).getLocation());
        System.out.println("Коордтинаты 1566 - "+$(byId("p1566")).getLocation());
        System.out.println("Размер 1563 - "+$(byId("p1563")).getSize());
        System.out.println("Размер 1566 - "+$(byId("p1566")).getSize());
        sleep(100000);*/
    }

    /**
     * нажатие на кнопку печати
     */
    public void clickPrint() {
        $(byClassName("print")).click();
    }

    public void switchOnPrintWindow() {
        switch (GetProperties.getPropertiesByText("browser")) {
            case "chrome":
                $(byId("")).click();
                break;
            case "firefox":
                System.out.println("В FireFox нет возможности предпросмотра перед печатью");
                break;
            default:
                System.out.println("Другие браузеры не рассматривались");
        }
    }

    public void clickRedaction() {
        $(byClassName("editions")).click();
    }

    public void checkEditions() {
        Assert.assertTrue($$(byText("с изменениями, не вступившими в силу")).size() > 0);
    }
}