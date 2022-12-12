package model.database.LoadSaveStrategies;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadSaveStrategyFactory {

    public static LoadSaveStrategy getStrategy () throws IOException {
        Properties properties = new Properties();
        InputStream is = new FileInputStream("./bestanden/settings.properties");
        properties.load(is);
        String name = properties.getProperty("strategy");
        LoadSaveStrategyEnum strategy = LoadSaveStrategyEnum.valueOf(name.toUpperCase());
        String className = strategy.getClassName();
        try {
            Class<?> cipherClass = Class.forName(className);
            return (LoadSaveStrategy) cipherClass.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid strategy");
        }
    }
}

