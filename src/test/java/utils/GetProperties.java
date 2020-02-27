package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * метод для вытаскивания данных из plus.properties
 */
public class GetProperties {
    public static String getPropertiesByText(String key) {
        Properties properties = new Properties();
        String res = "";
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/properties/plus.properties");
            properties.load(fis);
            res = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}