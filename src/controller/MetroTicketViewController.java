package controller;

import jxl.read.biff.BiffException;
import model.MetroCard;
import model.MetroEventsEnum;
import model.MetroFacade;
import model.MetroObserver;
import view.MetroTicketView;

import java.io.IOException;

public class MetroTicketViewController implements MetroObserver {

    private final MetroFacade metroFacade;
    private MetroTicketView metroTicketView;

    public MetroTicketViewController(MetroFacade metroFacade) throws BiffException, IOException {
        this.metroFacade = metroFacade;
        metroFacade.registerObeserver(MetroEventsEnum.OPEN_METROSTATION, this);
        metroFacade.registerObeserver(MetroEventsEnum.BUY_METROCARD,this);
    }


    public void setView(MetroTicketView metroTicketView){
        this.metroTicketView = metroTicketView;
    }

    @Override
    public void update(MetroEventsEnum e, String ...args) throws IOException {
        if(MetroEventsEnum.OPEN_METROSTATION.equals(e) | MetroEventsEnum.BUY_METROCARD.equals(e)){
            metroTicketView.updateDropdownIDs(metroFacade.getMetroCardIDList());
        }
    }

    public void buyMetroCards() throws IOException, BiffException {
        metroFacade.buyMetroCards();
    }

    public void getPrice(Boolean is26Min, Boolean is64Plus, Boolean isStudent, MetroCard metroCard, int rides) throws IOException {
        metroFacade.getPrice(is26Min,is64Plus,isStudent,metroCard, rides);
    }

    public MetroCard getMetrocard(String id){
        return metroFacade.getMetroCard(id);
    }

}
