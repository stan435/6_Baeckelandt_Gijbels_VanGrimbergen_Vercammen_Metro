package view;


import application.MetroMain;
import controller.ControlCenterPaneController;
import controller.MetroCardOverviewPaneController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import jxl.read.biff.BiffException;
import model.MetroFacade;
import view.panels.ControlCenter;
import view.panels.MetroCardOverviewPane;
import view.panels.SetupPane;

import java.io.IOException;

public class AdminMainPane extends BorderPane {
	public AdminMainPane(MetroFacade metroFacade) throws IOException, BiffException {
	    TabPane tabPane = new TabPane(); 	    
        MetroCardOverviewPane metroCardOverviewPane = new MetroCardOverviewPane();

        ControlCenterPaneController controlCenterPaneController = new ControlCenterPaneController(metroFacade);
        MetroCardOverviewPaneController metroCardOverviewPaneController = new MetroCardOverviewPaneController(metroFacade, metroCardOverviewPane);
        SetupPane setupPane = new SetupPane();
        ControlCenter controlCenter = new ControlCenter(controlCenterPaneController);
	//maak een controlCenterPane aan
	//maak een setupPane aan
        Tab metroCardOverviewTab = new Tab("Metro cards overview",metroCardOverviewPane);
        Tab controlCenterTab = new Tab("Control Center",controlCenter);
        Tab setupTab = new Tab("Setup", setupPane);
        tabPane.getTabs().add(controlCenterTab);
        tabPane.getTabs().add(metroCardOverviewTab);
        tabPane.getTabs().add(setupTab);
        this.setCenter(tabPane);
	}
}
