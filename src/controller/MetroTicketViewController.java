package controller;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.MetroCard;
import model.MetroEventsEnum;
import model.MetroFacade;
import model.MetroObserver;
import view.MetroTicketView;

import java.io.IOException;

public class MetroTicketViewController implements MetroObserver {
    private MetroFacade metroFacade = MetroFacade.getInstance();
    private MetroTicketView metroTicketView;

    public MetroTicketViewController() throws BiffException, IOException {
        metroFacade.registerObeserver(MetroEventsEnum.OPEN_METROSTATION, this);
        metroFacade.registerObeserver(MetroEventsEnum.BUY_METROCARD,this);
        metroFacade.registerObeserver(MetroEventsEnum.CLOSE_METROSTATION,this);
        metroFacade.registerObeserver(MetroEventsEnum.BUY_METROCARDTICKETS,this);

    }


    public void setView(MetroTicketView metroTicketView){
        this.metroTicketView = metroTicketView;
    }

    @Override
    public void update(MetroEventsEnum e, String ...args) throws IOException {
        if(MetroEventsEnum.OPEN_METROSTATION.equals(e) ){
            metroTicketView.openMetroStation(metroFacade.getMetroCardIDList());
        }
        if(MetroEventsEnum.BUY_METROCARD.equals(e)){
            metroTicketView.updateDropdownIDs(metroFacade.getMetroCardIDList());
        }
        if(MetroEventsEnum.CLOSE_METROSTATION.equals(e)){
            metroTicketView.closeMetrostation();
        }
        if(MetroEventsEnum.BUY_METROCARDTICKETS.equals(e)){
            metroTicketView.resetForm();
        }
    }

    public void buyMetroCards() throws IOException, BiffException {
        metroFacade.buyMetroCards();
    }

    public void getPriceAndText(Boolean is26Min, Boolean is64Plus, Boolean isStudent, MetroCard metroCard, int rides) throws IOException, BiffException, WriteException {
        metroTicketView.addTotalprice(metroFacade.getPrice(is26Min,is64Plus,isStudent,metroCard,rides));
        metroTicketView.addTotalPriceText(metroFacade.getPriceText(is26Min,is64Plus,isStudent,metroCard,rides));
    }

    public MetroCard getMetrocard(String id){
        return metroFacade.getMetroCard(id);
    }

    public void confirmRequest(int cardId, String rides, String moneyAmount) throws BiffException, IOException, WriteException {
        metroFacade.buyMetroCardTickets(getMetrocard(Integer.toString(cardId)), rides, moneyAmount);

    }

}
