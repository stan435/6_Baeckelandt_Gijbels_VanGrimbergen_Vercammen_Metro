package model.database.utilities;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.MetroCard;

import java.io.File;
import java.io.IOException;
import java.security.spec.ECField;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExcelLoadSaveTemplate {
    ExcelPlugin excelPlugin = new ExcelPlugin();

    public void save(File file, ArrayList<ArrayList<String>> args) throws BiffException, WriteException, IOException {
        excelPlugin.save(file,args);
    }

    public Map load (File file) throws BiffException, IOException {
        ArrayList<ArrayList<String>> list = excelPlugin.load(file);
        Map<String, MetroCard> map = new HashMap<>();
        for(int i = 0; i< list.size(); i++){
            map.put((list.get(i).get(0)),new MetroCard(Integer.parseInt(list.get(i).get(0)), YearMonth.parse(list.get(i).get(1).replaceAll("#","-")),Integer.parseInt(list.get(i).get(2)),Integer.parseInt(list.get(i).get(3))));
        }
        return map;
    }
}
