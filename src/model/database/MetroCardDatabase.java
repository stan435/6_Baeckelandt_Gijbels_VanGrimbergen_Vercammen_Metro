package model.database;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.MetroCard;
import model.database.LoadSaveStrategies.LoadSaveStrategy;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

public class MetroCardDatabase {
    private HashMap<Integer, MetroCard> metrocards = new HashMap<>();
    private LoadSaveStrategy loadSaveStrategy;

    public void setStrategy(LoadSaveStrategy loadSaveStrategy){
        try{
            this.loadSaveStrategy =  loadSaveStrategy;

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void load() throws IOException, BiffException {
        //metrocards = (HashMap<Integer, MetroCard>) new MetroCardTekstReader().load(new File(fileName));
        metrocards = (HashMap<Integer, MetroCard>) loadSaveStrategy.load();

    }
    public ArrayList<MetroCard> getMetroCardList(){
        Collection<MetroCard> values = metrocards.values();
        ArrayList<MetroCard> lijst = new ArrayList<MetroCard>(values);
        return  lijst;
    }

    public ArrayList<Integer> getMetroCardIDs() {
        return new ArrayList<>(metrocards.keySet());
    }

    public int getNextID(){
        return metrocards.size()+1;
    }

    public void addMetroCard(){
        MetroCard metroCard=new MetroCard(getNextID(), YearMonth.now(),2,0);
        metrocards.put(getNextID(),metroCard);
        try {
            save();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }

    public MetroCard getMetroCard(String id){
        return metrocards.get(Integer.parseInt(id));
    }

    public void updateMetroCardRides(MetroCard metroCard, int rides) throws BiffException, WriteException, IOException {
        metroCard.setBeschikbaar(metroCard.getBeschikbaar()+rides);
        save();
    }

    public void updateMetrocardGebruikt(String metroCardId) throws BiffException, WriteException, IOException {
        MetroCard metroCard = getMetroCard(metroCardId);
        metroCard.setBeschikbaar(metroCard.getBeschikbaar() -1);
        metroCard.setGebruikt(metroCard.getGebruikt() +1);
        save();
    }

    public void save() throws BiffException, IOException, WriteException {
        loadSaveStrategy.save(getMetroCardList());
    }
}
