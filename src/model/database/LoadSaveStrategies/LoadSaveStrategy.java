package model.database.LoadSaveStrategies;

import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface LoadSaveStrategy {
    Map load(File file) throws IOException, BiffException;
}
