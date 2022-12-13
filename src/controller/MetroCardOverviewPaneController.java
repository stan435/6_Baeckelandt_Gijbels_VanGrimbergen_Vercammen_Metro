package controller;

import jxl.read.biff.BiffException;
import model.MetroEventsEnum;
import model.MetroFacade;
import model.MetroObserver;
import view.panels.MetroCardOverviewPane;

import java.io.IOException;

public class MetroCardOverviewPaneController implements MetroObserver {
    MetroFacade metroFacade = new MetroFacade();
    MetroCardOverviewPane metroCardOverviewPane;

    public MetroCardOverviewPaneController() throws BiffException, IOException {
        metroFacade.registerObeserver(MetroEventsEnum.OPEN_METROSTATION, this);
    }

    @Override
    public void update(MetroEventsEnum e) throws IOException {
        if(MetroEventsEnum.OPEN_METROSTATION.equals(e)){
            metroCardOverviewPane.updateMetrocardList(metroFacade.getMetroCardList());
        }
    }

}
