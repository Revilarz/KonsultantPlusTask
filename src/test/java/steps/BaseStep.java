package steps;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import utils.GetProperties;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.*;

/**
 * Обычно используется для шагов которые используются многократно в разных тестов для минимизации дублирования кода.
 * Для получения времени не испульзуется анотация Step потому что они используются внутри других методов и может вознинкнуть конфликт в алюр отчете.
 */
public class BaseStep {

    /**
     * Получение текущих секунд
     */
    public static int getSeconds() {
        DateFormat dateFormat = new SimpleDateFormat("ss");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }

    /**
     * Получение текущих минут
     */
    public static int getMinutes() {
        DateFormat dateFormat = new SimpleDateFormat("mm");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }

    /**
     * Получение текущей даты в формате дд.мм.гггг
     */
    public static String getDateMonthYear() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }


    /**
     * Получение текущих часов
     */
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