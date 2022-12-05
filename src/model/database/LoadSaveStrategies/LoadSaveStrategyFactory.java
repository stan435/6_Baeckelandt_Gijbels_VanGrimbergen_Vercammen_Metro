package model.database.LoadSaveStrategies;


public class LoadSaveStrategyFactory {

    public static LoadSaveStrategy getStrategy (String name){
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

