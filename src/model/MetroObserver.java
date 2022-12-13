package model;

import jxl.read.biff.BiffException;

import java.io.IOException;

public interface MetroObserver {
    void update(MetroEventsEnum metroEventsEnum) throws BiffException, IOException;
}
