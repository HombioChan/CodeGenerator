package top.hombio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MConfiguration {
    private static String CONFIG_FILE_NAME="application.properties";


    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(CONFIG_FILE_NAME)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String get(String key){
        return properties.getProperty(key);
    }

}
