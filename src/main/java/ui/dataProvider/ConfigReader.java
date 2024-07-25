package ui.dataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try{
            String path = "src/main/resources/config.properties";
            FileInputStream inputStream =new FileInputStream(path);
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value != null) {
            return value.trim();
        } else {
            throw new RuntimeException("Property " + key + " не найден.");
        }
    }
}