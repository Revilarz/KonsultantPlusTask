package PageObjects;

import Steps.BaseStep;
import com.codeborne.selenide.Condition;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class DocumentEditPage {

    public static int finishTime;

    public void waitUpdateAllPage(){
        $(byAttribute("alt","Banner")).waitUntil(Condition.visible,200000);
        finishTime = BaseStep.getHours()*360+BaseStep.getMinutes()*60+BaseStep.getSeconds();
    }

    public void checkTimeLess10Seconds(){
        Assert.assertTrue(SearchResultPage.startTime-finishTime < 10);
    }

    public void checkTextIsExist(){
        $(byId("p4")).$(byText("налоговый")).isDisplayed();
        $(byId("p4")).$(byText("кодекс")).isDisplayed();
    }

}
