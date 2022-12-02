package model.database;

import model.MetroCard;
import model.database.utilities.MetroCardTekstReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class MetroCardDatabase {
    private HashMap<Integer, MetroCard> metrocards = new HashMap<>();
    private String fileName = "./src/metrocards.txt";

    public void load() throws IOException {
        try{
            metrocards = (HashMap<Integer, MetroCard>) new MetroCardTekstReader().load(new File(fileName));

        }catch (FileNotFoundException e){
            System.out.println("??");

        }

    }
    public ArrayList<MetroCard> getMetroCardList(){
        Collection<MetroCard> values = metrocards.values();
        ArrayList<MetroCard> lijst = new ArrayList<MetroCard>(values);
        return  lijst;
    }
}
