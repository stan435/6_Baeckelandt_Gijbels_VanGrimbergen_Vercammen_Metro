package controller;

import jxl.read.biff.BiffException;
import model.MetroEventsEnum;
import model.MetroFacade;
import model.MetroObserver;
import view.panels.MetroCardOverviewPane;

import java.io.IOException;

public class MetroCardOverviewPaneController implements MetroObserver {
    private final MetroFacade metroFacade;
    private final MetroCardOverviewPane metroCardOverviewPane;

    public MetroCardOverviewPaneController(MetroFacade metroFacade, MetroCardOverviewPane metroCardOverviewPane) throws BiffException, IOException {
        this.metroFacade = metroFacade;
        this.metroCardOverviewPane = metroCardOverviewPane;
        metroFacade.registerObeserver(MetroEventsEnum.OPEN_METROSTATION, this);
        metroFacade.registerObeserver(MetroEventsEnum.BUY_METROCARD,this);
    }

    @Override
    public void update(MetroEventsEnum e) throws IOException {
        if(MetroEventsEnum.OPEN_METROSTATION.equals(e)){
            metroCardOverviewPane.updateMetrocardList(metroFacade.getMetroCardList());
        }
    }

}
