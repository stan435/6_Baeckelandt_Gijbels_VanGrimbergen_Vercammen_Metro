package model;

import controller.ControlCenterPaneController;
import jxl.read.biff.BiffException;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;
import model.database.MetroCardDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetroFacade implements Subject {
    private Map<MetroEventsEnum, List<MetroObserver>> observers;
    private MetroCardDatabase metroCardDatabase = new MetroCardDatabase();


    public MetroFacade(){
        if (observers == null) {
            this.observers = new HashMap<>();
            for (MetroEventsEnum e : MetroEventsEnum.values()) {
                observers.put(e, new ArrayList<MetroObserver>());
            }
        }
    }


    public void openMetroStation() throws BiffException, IOException {
        metroCardDatabase.setStrategy(LoadSaveStrategyFactory.getStrategy());
        metroCardDatabase.load();
        metroCardDatabase.getMetroCardList();
        notifyObservers(MetroEventsEnum.OPEN_METROSTATION);
    }

    public ArrayList<MetroCard> getMetroCardList(){
        return metroCardDatabase.getMetroCardList();
    }

    public ArrayList<Integer> getMetroCardIDList(){
        return metroCardDatabase.getMetroCardIDs();
    }

    public void buyMetroCards() throws IOException {
        metroCardDatabase.setStrategy(LoadSaveStrategyFactory.getStrategy());
        metroCardDatabase.addMetroCard();
    }

    @Override
    public void registerObeserver(MetroEventsEnum e, MetroObserver o) {
        observers.get(e).add(o);
        String a = "";
    }

    @Override
    public void notifyObservers(MetroEventsEnum e) throws BiffException, IOException {
        for(MetroObserver o: observers.get(e)){
            o.update(e);
        }
    }



}
