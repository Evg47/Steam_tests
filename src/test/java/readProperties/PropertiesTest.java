package readProperties;

import java.io.IOException;

public class PropertiesTest {
    private static final String PROPERTY_FILE_NAME = "app.properties";
    private static boolean wasFulfilled = false;

    public static String getProperty(String key) {
        if (!wasFulfilled) {
            try {
                System.getProperties().load(ClassLoader.getSystemResourceAsStream(PROPERTY_FILE_NAME));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            wasFulfilled = true;
        }
        return System.getProperty(key);
    }
}
