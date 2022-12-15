package model;

import controller.ControlCenterPaneController;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.TicketpriceDecorator.TicketPrice;
import model.TicketpriceDecorator.TicketPriceDiscountEnum;
import model.TicketpriceDecorator.TicketPriceFactory;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;
import model.database.MetroCardDatabase;
import sun.security.util.AuthResources_zh_CN;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.*;

public class MetroFacade implements Subject {
    private final Map<MetroEventsEnum, List<MetroObserver>> observers = new HashMap<>();
    private MetroCardDatabase metroCardDatabase = new MetroCardDatabase();
    private MetroStation metroStation = new MetroStation();


    public MetroFacade(){
            for (MetroEventsEnum e : MetroEventsEnum.values()) {
                observers.put(e, new ArrayList<MetroObserver>());
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

    public void buyMetroCards() throws IOException, BiffException {
        metroCardDatabase.setStrategy(LoadSaveStrategyFactory.getStrategy());
        metroCardDatabase.addMetroCard();
        notifyObservers(MetroEventsEnum.BUY_METROCARD);
    }

    public double getPrice(Boolean is26Min, Boolean is64Plus, Boolean isStudent, MetroCard metroCard, int rides) throws IOException {
        ArrayList<String> list = getMetroTicketDiscountList();
        if(!list.contains(TicketPriceDiscountEnum.AGE64PLUSDISCOUNT.toString())){
            is64Plus = false;
        }
        if(!list.contains(TicketPriceDiscountEnum.STUDENTDISCOUNT.toString())){
            isStudent = false;
        }
        TicketPrice ticketPrice = TicketPriceFactory.createTicketPrice(is26Min,is64Plus,isStudent,metroCard, rides);
         return ticketPrice.getPrice();
    }

    public ArrayList<String> getMetroTicketDiscountList() throws IOException {
        ArrayList<String> list = new ArrayList<>();
        Properties properties = new Properties();
        InputStream is = new FileInputStream("./bestanden/settings.properties");
        properties.load(is);
        String name = properties.getProperty("discount");
        String[] list2 = name.split(",");
        for (int i = 0; i < list2.length; i++) {
            list.add(list2[i]);
        }
        return list;
    }

    public MetroCard getMetroCard(String id){
        return metroCardDatabase.getMetroCard(id);
    }

    public void scanMetroGate(String metroCardId, int gateId) throws BiffException, IOException, WriteException {
        String result = metroStation.scanMetroGate(gateId, getMetroCard(metroCardId));
        notifyObservers(MetroEventsEnum.SCAN_METROCARDS,result, Integer.toString(gateId));
        if(result.equals("metrocard " + getMetroCard(metroCardId).getId() + " is scanned")){
            metroCardDatabase.updateMetrocard(metroCardId);
            notifyObservers(MetroEventsEnum.UPDATE_METROCARD);
            notifyObservers(MetroEventsEnum.SCAN_METROCARDS_SUCCESFULL, Integer.toString(gateId));
        }else{
            notifyObservers(MetroEventsEnum.Alert_CONTROLCENTER, Integer.toString(gateId));
        }
    }

    public void walkThroughGate(String metroCardId, int gateId) throws BiffException, IOException {
        String result = metroStation.walkThroughGate(gateId, getMetroCard(metroCardId));
        notifyObservers(MetroEventsEnum.WALKTHROUGHGATE, result, Integer.toString(gateId));
        if(result.equals("Can not walk through \n closed gate")){
            notifyObservers(MetroEventsEnum.Alert_CONTROLCENTER, Integer.toString(gateId));
        }
    }

    public void activateGate(int gateId) throws BiffException, IOException {
        String result = metroStation.activateGate(gateId);
        notifyObservers(MetroEventsEnum.ACTIVATE_GATE,result, Integer.toString(gateId));
    }
    public void deactivateGate(int gateId) throws BiffException, IOException {
        String result = metroStation.deactivateGate(gateId);
        notifyObservers(MetroEventsEnum.DEACTIVATE_GATE,result, Integer.toString(gateId));
    }



    @Override
    public void registerObeserver(MetroEventsEnum e, MetroObserver o) {
        observers.get(e).add(o);
        String a = "";
    }

    @Override
    public void notifyObservers(MetroEventsEnum e, String ...args) throws BiffException, IOException {
        for(MetroObserver o: observers.get(e)){
            o.update(e, args);
        }
    }



}
