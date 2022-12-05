package model.database.utilities;
import model.MetroCard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

public class TekstLoadSaveTemplate<K,V> {

    public Map<String,MetroCard> load(File file) throws IOException {
        Map<String,MetroCard> returnMap = new HashMap<String,MetroCard>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null && !line.trim().equals("")) {
                line = line.replaceAll("#","-");
                String[] tokens = line.split(";");
                MetroCard element = maakObject(tokens);
                String key = getKey(tokens);
                returnMap.put(key,element);
                line = reader.readLine();
            }
        }
        return returnMap;
    }

    public MetroCard maakObject(String[] tokens){
        MetroCard metroCard = new MetroCard(Integer.parseInt(tokens[0]), YearMonth.parse(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
        return metroCard;
    }

    public String getKey(String[] tokens){
        return tokens[1];
    }
}




