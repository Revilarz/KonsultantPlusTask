package steps;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import utils.GetProperties;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.*;

public class BaseStep {

    @Step("Получение текущих секунд")
    public static int getSeconds() {
        DateFormat dateFormat = new SimpleDateFormat("ss");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }

    @Step("Получение текущих минут")
    public static int getMinutes() {
        DateFormat dateFormat = new SimpleDateFormat("mm");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }

    @Step("Получение текущих часов")
    public static int getHours() {
        DateFormat dateFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }

    @Step("Открытие ссылки")
    public void openLink() {
        Configuration.browser = GetProperties.getPropertiesByText("browser");
        open(GetProperties.getPropertiesByText("url"));
    }

}
