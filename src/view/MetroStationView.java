package view;

import controller.MetroStationViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.MetroEventsEnum;
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
	private VBox gate1, gate2,gate3;
	private HBox gates;
	private Scene scene;
	private  TextField stateText1 = new TextField();
	private TextField stateText2 = new TextField();
	private TextField stateText3 = new TextField();


	private Stage stage = new Stage();

	public MetroStationView(MetroStationViewController metroStationViewController){
		metroStationViewController.setView(this);
		stage.setTitle("METRO STATION VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(5);
		stage.setY(390);
		Group root = new Group();
		scene = new Scene(root, 650, 300);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
		scene.getStylesheets().add(AdminView.class.getResource("MetroStationViewStyle.css").toExternalForm());

		gates = new HBox();
		gates.setSpacing(10);
		root.getChildren().add(gates);

		Label gate1Text = new Label("Gate 1");
		Label gate2Text = new Label("Gate 2");
		Label gate3Text = new Label("Gate 3");
		Label idgate1 = new Label("MetrocardID:");
		Label idgate2 = new Label("MetrocardID:");
		Label idgate3 = new Label("MetrocardID:");


		gate1 = new VBox();
		gate1.setId("1");
		gate1.getStyleClass().add("vbox");
		stateText1.setMaxHeight(100);
		gate1.getChildren().addAll(gate1Text, idgate1, idsgate1, scanMetrocardgate1, walkThroughgate1,stateText1);
		disableNodes(gate1);

		scanMetrocardgate1.setOnAction(event -> scanMetroGate(metroStationViewController,idsgate1,1));
		walkThroughgate1.setOnAction(event -> walkThroughGate(metroStationViewController,idsgate1,1));


		gate2 = new VBox();
		gate2.setId("2");
		gate2.getStyleClass().add("vbox");
		gate2.getChildren().addAll(gate2Text, idgate2, idsgate2, scanMetrocardgate2, walkThroughgate2,stateText2);
		disableNodes(gate2);

		scanMetrocardgate2.setOnAction(event -> scanMetroGate(metroStationViewController,idsgate2,2));
		walkThroughgate2.setOnAction(event -> walkThroughGate(metroStationViewController,idsgate2,2));

		gate3 = new VBox();
		gate3.setId("3");
		gate3.getStyleClass().add("vbox");
		gate3.getChildren().addAll(gate3Text, idgate3, idsgate3, scanMetrocardgate3, walkThroughgate3,stateText3);
		disableNodes(gate3);

		scanMetrocardgate3.setOnAction(event -> scanMetroGate(metroStationViewController,idsgate3,3));
		walkThroughgate3.setOnAction(event -> walkThroughGate(metroStationViewController,idsgate3,3));

		gates.getChildren().addAll(gate1,gate2, gate3);

	}

	public void updateIds(ArrayList<Integer> list){
			metroCardsIDs = FXCollections.observableArrayList(list);
			idsgate1.setItems(metroCardsIDs);
			idsgate2.setItems(metroCardsIDs);
			idsgate3.setItems(metroCardsIDs);
	}

	public void setStyleOpen(String id){
		VBox vBox = (VBox) scene.lookup("#" + id);
		vBox.setStyle("-fx-background-color: #02f8b6");
		enableNodes(vBox,vBox.getChildren().get(5));
	}

	public void setStyleClosed(String id){
		VBox vBox = (VBox) scene.lookup("#" + id);
		vBox.setStyle("-fx-background-color: #f81e1e");
		disableNodes(vBox);
	}

	public void updateStatText(String ...state){
		VBox vBox = (VBox) scene.lookup("#" + state[1]);
		TextField textField =(TextField)  vBox.getChildren().get(5);
		textField.setText(state[0]);
	}
	public void enableNodes(VBox vBox,Node exception){
		for (int i = 0; i < vBox.getChildren().size(); i++) {
			if(vBox.getChildren().get(i) != exception){
				vBox.getChildren().get(i).setDisable(false);
			}
		}

	}
	public void disableNodes(VBox vBox) {
		for (int i = 0; i < vBox.getChildren().size(); i++) {
			vBox.getChildren().get(i).setDisable(true);
		}
		TextField textField = (TextField) vBox.getChildren().get(5);
		textField.setText("");
	}

	public void scanMetroGate(MetroStationViewController metroStationViewController, ChoiceBox choiceBox, int gateId){
		try {
			metroStationViewController.scanMetroCard(String.valueOf(choiceBox.getValue()), gateId);
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

	public void walkThroughGate(MetroStationViewController metroStationViewController, ChoiceBox choiceBox, int gateId){
		try {
			metroStationViewController.walkThroughGate(String.valueOf(choiceBox.getValue()), gateId);
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeMetroStation(){
		for (int i = 0; i < gates.getChildren().size(); i++) {
			setStyleClosed(gates.getChildren().get(i).getId());
		}
	}

}