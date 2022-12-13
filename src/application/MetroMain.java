package application;
	
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
		AdminView adminView = new AdminView();
		MetroTicketView metroTicketView = new MetroTicketView();
		MetroStationView metroStationView = new MetroStationView();
		MetroFacade metroFacade = new MetroFacade();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
