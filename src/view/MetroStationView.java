package view;

import controller.MetroStationViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jxl.read.biff.BiffException;
import view.panels.SetupPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class MetroStationView {
	private ObservableList<Integer> metroCardsIDs;
	private ChoiceBox<Integer> idsgate1 = new ChoiceBox<>();
	private ChoiceBox<Integer> idsgate2 = new ChoiceBox<>();
	private ChoiceBox<Integer> idsgate3 = new ChoiceBox<>();
	private Button scanMetrocardgate1 = new Button("Scan Metrocard");
	private Button scanMetrocardgate2 = new Button("Scan Metrocard");
	private Button scanMetrocardgate3 = new Button("Scan Metrocard");
	private Button walkThroughgate1 = new Button("Walk Through Gate");
	private Button walkThroughgate2 = new Button("Walk Through Gate");
	private Button walkThroughgate3 = new Button("Walk Through Gate");
	private Label updateStatusgate1 = new Label();
	private Label updateStatusgate2 = new Label();
	private Label updateStatusgate3 = new Label();
	private VBox gate1;
	private Label stateText;

	private Stage stage = new Stage();

	public MetroStationView(MetroStationViewController metroStationViewController){
		metroStationViewController.setView(this);
		stage.setTitle("METRO STATION VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(5);
		stage.setY(390);
		Group root = new Group();
		Scene scene = new Scene(root, 650, 300);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
		scene.getStylesheets().add(AdminView.class.getResource("MetroStationViewStyle.css").toExternalForm());

		HBox hBox = new HBox();
		hBox.setSpacing(10);
		root.getChildren().add(hBox);

		Label gate1Text = new Label("Gate 1");
		Label gate2Text = new Label("Gate 2");
		Label gate3Text = new Label("Gate 3");
		Label idgate1 = new Label("MetrocardID:");
		Label idgate2 = new Label("MetrocardID:");
		Label idgate3 = new Label("MetrocardID:");


		gate1 = new VBox();
		gate1.getStyleClass().add("vbox");
		gate1.getChildren().addAll(gate1Text, idgate1, idsgate1, scanMetrocardgate1, walkThroughgate1, updateStatusgate1);

		scanMetrocardgate1.setOnAction(event -> {
			try {
				metroStationViewController.scanMetroCard(String.valueOf(idsgate1.getValue()), 1);
			} catch (BiffException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		VBox gate2 = new VBox();
		gate2.getStyleClass().add("vbox");
		gate2.getChildren().addAll(gate2Text, idgate2, idsgate2, scanMetrocardgate2, walkThroughgate2, updateStatusgate2);


		VBox gate3 = new VBox();
		gate3.getStyleClass().add("vbox");
		gate3.getChildren().addAll(gate3Text, idgate3, idsgate3, scanMetrocardgate3, walkThroughgate3, updateStatusgate3);


		hBox.getChildren().addAll(gate1,gate2, gate3);

	}

	public void updateIds(ArrayList<Integer> list){
			metroCardsIDs = FXCollections.observableArrayList(list);
			idsgate1.setItems(metroCardsIDs);
			idsgate2.setItems(metroCardsIDs);
			idsgate3.setItems(metroCardsIDs);

	}

	public void updateStatText(String ...state){
		gate1.getChildren().remove(stateText);
		String text = "";
		for (int i = 0; i < state.length; i++) {
			text = state[i];
		}
		stateText= new Label(text);
		stateText.setId("state");
		gate1.getChildren().add(stateText);
	}

}