package model.database.LoadSaveStrategies;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.MetroCard;
import model.database.utilities.TekstLoadSaveTemplate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class MetroCardsTekstLoadSaveStrategy extends TekstLoadSaveTemplate implements LoadSaveStrategy {
    @Override
    public Map load() throws IOException {
        return super.load(new File("bestanden/metrocards.txt"));
    }

    @Override
    public void save(ArrayList<MetroCard> list) throws IOException, BiffException, WriteException {

    }

}