package application;
	
import controller.MetroStationViewController;
import controller.MetroTicketViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import jxl.read.biff.BiffException;
import model.MetroFacade;
import model.database.LoadSaveStrategies.LoadSaveStrategy;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;
import view.AdminView;
import view.MetroStationView;
import view.MetroTicketView;

import java.io.IOException;


public class MetroMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException, BiffException {
		MetroFacade metroFacade = new MetroFacade();
		MetroTicketViewController metroTicketViewController = new MetroTicketViewController(metroFacade);
		MetroStationViewController metroStationViewController = new MetroStationViewController(metroFacade);
		AdminView adminView = new AdminView(metroFacade);
		MetroTicketView metroTicketView = new MetroTicketView(metroTicketViewController);
		MetroStationView metroStationView = new MetroStationView(metroStationViewController);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
