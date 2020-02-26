package pageObjects;

import steps.BaseStep;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage extends BaseStep{

    public static int startTime;

    public void clickFirstRow(){
        $(byAttribute("index","0")).click();
        startTime = getHours()*360+getMinutes()*60+getSeconds();
    }
}
