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
    private final MetroStationView metroStationView;

    public MetroStationViewController(MetroFacade metroFacade, MetroStationView metroStationView) throws BiffException, IOException {
        this.metroFacade = metroFacade;
        this.metroStationView = metroStationView;
        metroFacade.registerObeserver(MetroEventsEnum.OPEN_METROSTATION, this);
    }


    @Override
    public void update(MetroEventsEnum e) throws BiffException, IOException {
        if (MetroEventsEnum.OPEN_METROSTATION.equals(e)) {
            metroStationView.updateIds(metroFacade.getMetroCardIDList());
        }
    }
}
