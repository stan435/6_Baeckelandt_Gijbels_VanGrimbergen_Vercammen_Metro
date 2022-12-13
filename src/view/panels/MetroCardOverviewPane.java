package view.panels;


import controller.MetroCardOverviewPaneController;
import jxl.read.biff.BiffException;
import model.MetroCard;
import model.database.MetroCardDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;


public class MetroCardOverviewPane extends GridPane{
	private TableView<MetroCard> table;
	private ObservableList<MetroCard> metroCards;
	private MetroCardOverviewPaneController metroCardOverviewPaneController = new MetroCardOverviewPaneController();

	public MetroCardOverviewPane() throws IOException, BiffException {
		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);
		this.add(new Label("List of Metro cards:"), 0, 0, 1, 1);
		table = new TableView<MetroCard>();
		table.setMaxWidth(600);
		TableColumn<MetroCard, Integer> colId = new TableColumn<MetroCard, Integer>("MetroCard id");
		colId.setMinWidth(50);
		colId.setCellValueFactory(new PropertyValueFactory<MetroCard, Integer>("id"));
		TableColumn<MetroCard, YearMonth> colBuyDate = new TableColumn<MetroCard, YearMonth>("Buy Date");
		colBuyDate.setMinWidth(150);
		colBuyDate.setCellValueFactory(new PropertyValueFactory<MetroCard, YearMonth>("date"));
		TableColumn<MetroCard, Integer> colint1 = new TableColumn<MetroCard, Integer>("geen idee");
		colint1.setMinWidth(150);
		colint1.setCellValueFactory(new PropertyValueFactory<MetroCard, Integer>("int1"));
		TableColumn<MetroCard, Integer> colint2 = new TableColumn<MetroCard, Integer>("geen idee");
		colint2.setMinWidth(150);
		colint2.setCellValueFactory(new PropertyValueFactory<MetroCard, Integer>("int2"));
		table.getColumns().addAll(colId,colBuyDate,colint1,colint2);
		this.getChildren().addAll(table);
	}

		public void updateMetrocardList(ArrayList<MetroCard> list) throws IOException {
			metroCards = FXCollections.observableArrayList(list);
			table.setItems(metroCards);
			table.refresh();
		}

}
