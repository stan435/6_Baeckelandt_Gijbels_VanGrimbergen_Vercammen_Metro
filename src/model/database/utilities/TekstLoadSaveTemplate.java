package model.database.utilities;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.MetroCard;

import java.io.*;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TekstLoadSaveTemplate<K,V> {

    public Map<Integer,MetroCard> load(File file) throws IOException {
        Map<Integer,MetroCard> returnMap = new HashMap<Integer,MetroCard>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null && !line.trim().equals("")) {
                line = line.replaceAll("#","-");
                String[] tokens = line.split(";");
                MetroCard element = maakObject(tokens);
                Integer key = getKey(tokens);
                returnMap.put(key,element);
                line = reader.readLine();
            }
        }
        return returnMap;
    }
    public void save(File file, ArrayList<MetroCard> args) throws BiffException, WriteException, IOException {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < args.size();i++) {
            list.add(args.get(i).getId() + ";" + args.get(i).getDate() + ";" + args.get(i).getBeschikbaar() + ";" + args.get(i).getGebruikt() + "\n" );
        }
        FileWriter writer = new FileWriter(file);
        for(String str: list) {
            writer.write(str);
        }
        writer.close();
}

    public MetroCard maakObject(String[] tokens){
        MetroCard metroCard = new MetroCard(Integer.parseInt(tokens[0]), YearMonth.parse(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
        return metroCard;
    }

    public Integer getKey(String[] tokens){
        return Integer.parseInt(tokens[0]);
    }
}




