package Steps;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static com.codeborne.selenide.Selenide.*;

public class BaseStep {

    public static int getSeconds() {
        DateFormat dateFormat = new SimpleDateFormat("ss");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }

    public static int getMinutes() {
        DateFormat dateFormat = new SimpleDateFormat("mm");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }

    public static int getHours() {
        DateFormat dateFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }

    @Step("Открытие ссылки")
    public void openLink(){
        //Configuration.browser = "firefox";
        open("http://base.consultant.ru/cons/");
    }

}
