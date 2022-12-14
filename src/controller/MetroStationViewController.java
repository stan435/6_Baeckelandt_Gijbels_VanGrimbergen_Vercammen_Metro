package controller;

import jxl.read.biff.BiffException;
import model.MetroEventsEnum;
import model.MetroFacade;
import model.MetroObserver;
import view.MetroStationView;
import view.panels.MetroCardOverviewPane;

import java.io.IOException;

public class MetroStationViewController implements MetroObserver {
    private final MetroFacade metroFacade;
    private MetroStationView metroStationView;

    public MetroStationViewController(MetroFacade metroFacade) throws BiffException, IOException {
        this.metroFacade = metroFacade;
        metroFacade.registerObeserver(MetroEventsEnum.OPEN_METROSTATION, this);
        metroFacade.registerObeserver(MetroEventsEnum.BUY_METROCARD,this);
    }


    @Override
    public void update(MetroEventsEnum e) throws BiffException, IOException {
        if (MetroEventsEnum.OPEN_METROSTATION.equals(e) | MetroEventsEnum.BUY_METROCARD.equals(e)) {
            metroStationView.updateIds(metroFacade.getMetroCardIDList());
        }
    }

    public void setView(MetroStationView metroStationView){
        this.metroStationView = metroStationView;
    }
}
