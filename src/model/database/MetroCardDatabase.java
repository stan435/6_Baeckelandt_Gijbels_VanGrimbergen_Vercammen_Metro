package model.database;

import jxl.read.biff.BiffException;
import model.MetroCard;
import model.database.LoadSaveStrategies.LoadSaveStrategy;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class MetroCardDatabase {
    private HashMap<Integer, MetroCard> metrocards = new HashMap<>();
    private String fileName = "./bestanden/metrocards.txt";
    private LoadSaveStrategy loadSaveStrategy;

    public void setStrategy(){
        try{
            this.loadSaveStrategy =  LoadSaveStrategyFactory.getStrategy();

        }catch (IllegalArgumentException | IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void load() throws IOException, BiffException {
        //metrocards = (HashMap<Integer, MetroCard>) new MetroCardTekstReader().load(new File(fileName));
        metrocards = (HashMap<Integer, MetroCard>) loadSaveStrategy.load(new File(fileName));

    }
    public ArrayList<MetroCard> getMetroCardList(){
        Collection<MetroCard> values = metrocards.values();
        ArrayList<MetroCard> lijst = new ArrayList<MetroCard>(values);
        return  lijst;
    }
}