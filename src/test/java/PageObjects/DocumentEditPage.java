package PageObjects;

import Steps.BaseStep;
import com.codeborne.selenide.Condition;
import org.junit.Assert;

import javax.swing.plaf.synth.SynthOptionPaneUI;
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

    public void focusOnSecondWindow(){
        switchTo().window(1);
    }

    public void waitUpdateAllPage(){
        $(byAttribute("data-title","Сайт КонсультантПлюс")).waitWhile(Condition.enabled,20000);
        finishTime = BaseStep.getHours()*360+BaseStep.getMinutes()*60+BaseStep.getSeconds();
    }

    public void checkTimeLess10Seconds(){
        System.out.println("result = "+(finishTime - SearchResultPage.startTime));
        Assert.assertTrue(finishTime - SearchResultPage.startTime < 10);
    }


    /**
     * Проверка что в названии вкалдки содержатся фразы - налоговый кодекс и часть вторая
     */
    public void checkTextInTitle(){
        Assert.assertTrue(title().toLowerCase().contains("налоговый кодекс")&title().toLowerCase().contains("часть вторая"));
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

        //залипала Ctrl
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor dataFlavor = DataFlavor.stringFlavor;
        String text = "";
        if (systemClipboard.isDataFlavorAvailable(dataFlavor)) {
            text = (String) systemClipboard.getData(dataFlavor);
        }
        //System.out.println("Текст из буфера - "+text);
        Assert.assertEquals(text,"нк ч2");
    }

    public void checkTextIsExist(){
        //$(byId("p4")).getText();
        System.out.println($(byId("segm1")).getText());
        $(byId("p4")).$(byText("налоговый")).isDisplayed();
        $(byId("p4")).$(byText("кодекс")).isDisplayed();


    }

}
