package top.hombio;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFactory {

    private static final String DB_FILE_NAME = "properties/db.properties";
    private static final String APPLICATION_FILE_NAME = "properties/application.properties";
    private static final String MAPPING_FILE_NAME = "properties/data-type-mapping.properties";

    public static Properties getDbProperties(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(DB_FILE_NAME));
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Properties getApplicationProperties(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(APPLICATION_FILE_NAME));
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Properties getDataTypeMappingProperties(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(MAPPING_FILE_NAME));
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
