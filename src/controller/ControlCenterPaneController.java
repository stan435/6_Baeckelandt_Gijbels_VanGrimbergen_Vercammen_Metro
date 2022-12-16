package controller;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.MetroEventsEnum;
import model.MetroFacade;
import model.MetroObserver;
import view.panels.ControlCenter;

import java.io.IOException;

public class ControlCenterPaneController implements MetroObserver {
    private final MetroFacade metroFacade;
    private ControlCenter controlCenter;


    public ControlCenterPaneController(MetroFacade metroFacade){
        this.metroFacade = metroFacade;
        metroFacade.registerObeserver(MetroEventsEnum.DEACTIVATE_GATE, this);
        metroFacade.registerObeserver(MetroEventsEnum.Alert_CONTROLCENTER,this);
        metroFacade.registerObeserver(MetroEventsEnum.SCAN_METROCARDS,this);
        metroFacade.registerObeserver(MetroEventsEnum.SCAN_METROCARDS_SUCCESFULL,this);
        metroFacade.registerObeserver(MetroEventsEnum.BUY_METROCARDTICKETS,this);
    }

    public void setView(ControlCenter controlCenter){
        this.controlCenter = controlCenter;
    }


    @Override
    public void update(MetroEventsEnum e, String ...args) throws BiffException, IOException {
        if(MetroEventsEnum.DEACTIVATE_GATE.equals(e)){
            if(args[0].equals("gate cannot be deactivated")){
                controlCenter.styleOpenOnId(args[1]);
            }
        }
        if(MetroEventsEnum.Alert_CONTROLCENTER.equals(e)){
            controlCenter.addAllert(args[0]);
        }
        if(MetroEventsEnum.SCAN_METROCARDS_SUCCESFULL.equals(e)){
            controlCenter.updateGateScannedCards(args[0]);
        }
        if(MetroEventsEnum.BUY_METROCARDTICKETS.equals(e)){
            controlCenter.updateTicketNumberFields(args[0], args[1]);
        }

    }


    public void openMetroStation() throws BiffException, IOException {
        metroFacade.openMetroStation();
    }

    public void closeMetroStation() throws BiffException, IOException, WriteException {
        metroFacade.closeMetroStation();
    }

    public void activateGate(int gateId) throws BiffException, IOException {
        metroFacade.activateGate(gateId);
    }

    public void deactivateGate(int gateId) throws BiffException, IOException {
        metroFacade.deactivateGate(gateId);
    }

}
