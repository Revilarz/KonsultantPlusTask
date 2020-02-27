package pageObjects;

import steps.BaseStep;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage extends BaseStep{

    /**
     * Переменная для хранения даты начала загрузки документа
     */
    public static int startTime;

    /**
     * Выбор первого элемента поиска и получение времени начала открытия документа
     */
    public void clickFirstRow(){
        $(byAttribute("index","0")).click();
        startTime = getHours()*360+getMinutes()*60+getSeconds();
    }
}
