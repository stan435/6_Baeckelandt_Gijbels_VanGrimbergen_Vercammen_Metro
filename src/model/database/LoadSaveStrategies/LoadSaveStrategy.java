package model.database.LoadSaveStrategies;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.MetroCard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public interface LoadSaveStrategy {
    Map load() throws IOException, BiffException;
    void save(ArrayList<MetroCard> list) throws IOException,BiffException, WriteException;
}