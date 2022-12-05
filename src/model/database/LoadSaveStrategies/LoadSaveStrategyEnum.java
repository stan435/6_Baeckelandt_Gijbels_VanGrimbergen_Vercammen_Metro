package model.database.LoadSaveStrategies;

public enum LoadSaveStrategyEnum {
    TEKST("model.database.LoadSaveStrategies.MetroCardsTekstLoadSaveStrategy"),
    EXCEL("model.database.LoadSaveStrategies.MetroCardsExcelLoadSaveStrategy");

    private final String klassenaam;

    LoadSaveStrategyEnum(String klassenaam){
        this.klassenaam =  klassenaam;
    }

    public String getClassName() {
        return this.klassenaam;
    }
}
