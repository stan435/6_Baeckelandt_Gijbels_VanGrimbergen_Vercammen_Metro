package model;

import jxl.read.biff.BiffException;

import java.io.IOException;

public interface MetroObserver {
    void update(MetroEventsEnum metroEventsEnum, String ...args) throws BiffException, IOException;
}
