package model;

import jxl.read.biff.BiffException;

import java.io.IOException;

public interface Subject {
    void registerObeserver(MetroEventsEnum e, MetroObserver o);
    void notifyObservers(MetroEventsEnum e, String ...args) throws BiffException, IOException;
}
