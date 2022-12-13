package controller;

import jxl.read.biff.BiffException;
import model.MetroEventsEnum;
import model.MetroFacade;
import model.MetroObserver;
import view.MetroTicketView;

import java.io.IOException;

public class MetroTicketViewController implements MetroObserver {

    private final MetroFacade metroFacade;
    private final MetroTicketView metroTicketView;

    public MetroTicketViewController(MetroFacade metroFacade, MetroTicketView metroTicketView) throws BiffException, IOException {
        this.metroFacade = metroFacade;
        this.metroTicketView = metroTicketView;
        metroFacade.registerObeserver(MetroEventsEnum.OPEN_METROSTATION, this);
        metroFacade.registerObeserver(MetroEventsEnum.BUY_METROCARD,this);
    }

    public void getMetroCardIDs() {
        metroFacade.getMetroCardIDList();
    }

    @Override
    public void update(MetroEventsEnum e) throws IOException {
        if(MetroEventsEnum.OPEN_METROSTATION.equals(e)){
            metroTicketView.updateDropdownIDs(metroFacade.getMetroCardIDList());
        }
    }

    public void buyMetroCards() throws IOException {
        metroFacade.buyMetroCards();
    }

}
