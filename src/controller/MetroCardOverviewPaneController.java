package controller;

import jxl.read.biff.BiffException;
import model.MetroEventsEnum;
import model.MetroFacade;
import model.MetroObserver;
import view.MetroStationView;
import view.panels.MetroCardOverviewPane;

import java.io.IOException;

public class MetroCardOverviewPaneController implements MetroObserver {
    private MetroFacade metroFacade = MetroFacade.getInstance();
    private MetroCardOverviewPane metroCardOverviewPane;

    public MetroCardOverviewPaneController() throws BiffException, IOException {
        metroFacade.registerObeserver(MetroEventsEnum.OPEN_METROSTATION, this);
        metroFacade.registerObeserver(MetroEventsEnum.BUY_METROCARD,this);
        metroFacade.registerObeserver(MetroEventsEnum.UPDATE_METROCARD,this);

    }

    public void setView(MetroCardOverviewPane metroCardOverviewPane){
        this.metroCardOverviewPane = metroCardOverviewPane;

    }

    @Override
    public void update(MetroEventsEnum e, String ...args) throws IOException {
        if(MetroEventsEnum.OPEN_METROSTATION.equals(e) | MetroEventsEnum.BUY_METROCARD.equals(e) | MetroEventsEnum.UPDATE_METROCARD.equals(e)){
            metroCardOverviewPane.updateMetrocardList(metroFacade.getMetroCardList());
        }
    }

}
