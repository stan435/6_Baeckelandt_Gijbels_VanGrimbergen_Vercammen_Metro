package controller;

import jxl.read.biff.BiffException;
import model.MetroEventsEnum;
import model.MetroFacade;
import model.MetroObserver;

import java.io.IOException;

public class ControlCenterPaneController  {

    MetroFacade metroFacade = new MetroFacade();

    /*


    public ControlCenterPaneController(){
        metroFacade.registerObeserver(MetroEventsEnum.OPEN_METROSTATION, this);
    }

    @Override
    public void update(MetroEventsEnum e) throws BiffException, IOException {
        if(MetroEventsEnum.OPEN_METROSTATION.equals(e)){
            openMetroStation();
        }
    }

     */


    public void openMetroStation() throws BiffException, IOException {
        metroFacade.openMetroStation();
    }

}
