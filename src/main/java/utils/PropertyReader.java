package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public String propertyReader(String filePath, String key) {

        String value = null;

        // InputStream is required to load into properties
        try(InputStream input = new FileInputStream(filePath)){

            // Property class object creation
            Properties prop = new Properties();

            // Load properties file
            prop.load(input);

            // getProperty() method will fetch value for given key
            value = prop.getProperty(key);

        } catch (IOException e){
            e.printStackTrace();
        }
        return value;
    }
}
