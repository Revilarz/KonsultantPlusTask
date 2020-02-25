package PageObjects;

import Steps.BaseStep;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

    public static int startTime;

    public void clickFirstRow(){
        $(byAttribute("index","0")).click();
        startTime = BaseStep.getHours()*360+BaseStep.getMinutes()*60+BaseStep.getSeconds();
    }
}
