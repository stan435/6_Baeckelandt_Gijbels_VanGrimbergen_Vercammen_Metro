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
        metroFacade.registerObeserver(MetroEventsEnum.SCAN_METROCARDS,this);
    }


    @Override
    public void update(MetroEventsEnum e, String ...args) throws BiffException, IOException {
        if (MetroEventsEnum.OPEN_METROSTATION.equals(e) | MetroEventsEnum.BUY_METROCARD.equals(e)) {
            metroStationView.updateIds(metroFacade.getMetroCardIDList());
        }
        if(MetroEventsEnum.SCAN_METROCARDS.equals(e)){
            metroStationView.updateStatText(args);
        }
    }

    public void setView(MetroStationView metroStationView){
        this.metroStationView = metroStationView;
    }

    public void scanMetroCard(String metroCardId, int gateId) throws BiffException, IOException {
        metroFacade.scanMetroGate(metroCardId, gateId);
    }
}
