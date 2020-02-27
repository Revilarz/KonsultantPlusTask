package pageObjects;

import io.qameta.allure.Allure;
import steps.BaseStep;
import com.codeborne.selenide.Condition;
import org.junit.Assert;
import utils.GetProperties;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static steps.BaseStep.getDateMonthYear;

public class DocumentEditPage {

    /**
     * переменная для хранения времени окончания загрузки страницы
     */
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
        finishTime = BaseStep.getHours() * 360 + BaseStep.getMinutes() * 60 + BaseStep.getSeconds();
    }

    /**
     * проверка что время прогрузки меньше 10 сек
     */
    public void checkTimeLessNSeconds() {
        //System.out.println("result = " + (finishTime - SearchResultPage.startTime));
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
    public void checkTextInSearchBox() {
        Assert.assertEquals($(byId("dictFilter")).getAttribute("value"), "нк ч2");
    }


    /**
     * переключение на фрейм
     */
    public void switchToFrame() {
        switch (GetProperties.getPropertiesByText("browser")) {
            case "firefox":
                switchTo().frame(1);
                break;
            case "chrome":
                switchTo().frame(2);
                break;
            default:
                switchTo().defaultContent();
        }

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
        sleep(3000);
        $(byId("searchFindBtn")).click();
    }

    /**
     * нажать на пункт оглавления для перехода
     */
    public void clickOnHeader() {
        $(byId("segm1")).click();
    }

    /**
     *переменная для хранения текста для дальнейшего сравнения
     */
    private static String text1 = "";

    /**
     * выделяю текст (читерским способом) и сохраняю в переменную через буфер для дальнейшего сравнения с тем что выводится в печать
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

        //System.out.println(text1);
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

    /**
     * метод для взаимодействия с окном печати ... не реализован
     */
    public void switchOnPrintWindow() {
        switch (GetProperties.getPropertiesByText("browser")) {
            case "chrome":
                System.out.println("Пока не знаю как переключиться на окно печати для взаимодействия с элементами");
                break;
            case "firefox":
                System.out.println("В FireFox нет возможности предпросмотра перед печатью");
                break;
            default:
                System.out.println("Другие браузеры не рассматривались");
        }

        sleep(3000);
        close();
    }

    /**
     * Нажатие на кнопку Редации
     */
    public void clickRedaction() {
        $(byClassName("editions")).click();
    }

    /**
     * Проверка количества редакций с изменениями не вступившими в силу
     */
    public void checkEditions() {
        int k = 0;
        for (int i = 0; i < $(byClassName("editionsView")).$$(byAttribute("class", "text v")).size(); i++) {
            if ($(byClassName("editionsView")).$$(byAttribute("class", "text v")).get(i).getText().contains("с изменениями, не вступившими в силу")) {
                k++;
            }
        }
        //System.out.println("k = "+k);
        Assert.assertTrue(k > 0);
    }


    /**
     * Сравнение дат с текущей у документов с изменениями не вступившими в силу и вывод их в лог
     */
    public void checkAndPrintDate() throws ParseException {
        String dateInWeb = "";
        for (int i = 0; i < $(byClassName("editionsView")).$$(byAttribute("class", "text v")).size(); i++) {
            if ($(byClassName("editionsView")).$$(byAttribute("class", "text v")).get(i).getText().contains("с изменениями, не вступившими в силу")) {
                //System.out.println($(byClassName("editionsView")).$$(byAttribute("class", "redDate")).get(i).getText());
                Pattern p = Pattern.compile("(\\d{2}.\\d{2}.\\d{4})");
                Matcher m = p.matcher($(byClassName("editionsView")).$$(byAttribute("class", "redDate")).get(i).getText());
                while (m.find()) {
                    dateInWeb = m.group(1);
                }
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                Date date1 = formatter.parse(dateInWeb);
                Date date2 = formatter.parse(getDateMonthYear());
                //System.out.println(formatter.format(date1) + " < " + formatter.format(date2));
                Allure.addAttachment("Дата начала действия редакций: ", formatter.format(date1));
                Assert.assertTrue(date1.compareTo(date2) > 0);
            }
        }
    }
}