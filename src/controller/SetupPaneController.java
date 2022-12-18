package controller;

import jxl.read.biff.BiffException;
import model.MetroEventsEnum;
import model.MetroFacade;
import model.MetroObserver;
import view.MetroTicketView;
import view.panels.SetupPane;

import java.io.IOException;

public class SetupPaneController implements MetroObserver {
    private MetroFacade metroFacade = MetroFacade.getInstance();
    private SetupPane setupPane;

    public SetupPaneController() throws BiffException, IOException {
        metroFacade.registerObeserver(MetroEventsEnum.OPEN_METROSTATION, this);
    }

    public void setView(SetupPane setupPane){
        this.setupPane = setupPane;
    }

    @Override
    public void update(MetroEventsEnum e, String ...args) throws IOException {
        if(MetroEventsEnum.OPEN_METROSTATION.equals(e)){
            setupPane.updateCheckBox();
        }
    }
}
