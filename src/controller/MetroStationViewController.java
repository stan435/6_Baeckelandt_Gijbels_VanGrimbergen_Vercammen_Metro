package controller;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
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
        metroFacade.registerObeserver(MetroEventsEnum.WALKTHROUGHGATE,this);
        metroFacade.registerObeserver(MetroEventsEnum.ACTIVATE_GATE,this);
        metroFacade.registerObeserver(MetroEventsEnum.DEACTIVATE_GATE,this);
    }


    @Override
    public void update(MetroEventsEnum e, String ...args) throws BiffException, IOException {
        if (MetroEventsEnum.OPEN_METROSTATION.equals(e) | MetroEventsEnum.BUY_METROCARD.equals(e)) {
            metroStationView.updateIds(metroFacade.getMetroCardIDList());
        }
        if(MetroEventsEnum.SCAN_METROCARDS.equals(e) | MetroEventsEnum.WALKTHROUGHGATE.equals(e)){
            metroStationView.updateStatText(args);
        }
        if(MetroEventsEnum.ACTIVATE_GATE.equals(e)){
            metroStationView.updateStatText(args);
            metroStationView.setStyleOpen(args[1]);
        }
        if(MetroEventsEnum.DEACTIVATE_GATE.equals(e)){
            if(args[0].equals("gate cannot be deactivated")) {
                metroStationView.updateStatText(args);
            }else{
                metroStationView.updateStatText(args);
                metroStationView.setStyleClosed(args[1]);
            }
        }
    }

    public void setView(MetroStationView metroStationView){
        this.metroStationView = metroStationView;
    }

    public void scanMetroCard(String metroCardId, int gateId) throws BiffException, IOException, WriteException {
        metroFacade.scanMetroGate(metroCardId, gateId);
    }

    public void walkThroughGate(String metrocardId, int gateId) throws BiffException, IOException {
        metroFacade.walkThroughGate(metrocardId,gateId);
    }
}
