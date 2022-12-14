package view;

import com.sun.xml.internal.bind.v2.model.core.ID;
import controller.MetroTicketViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jxl.read.biff.BiffException;
import model.MetroCard;
import model.MetroFacade;
import model.database.MetroCardDatabase;

import java.io.IOException;
import java.util.ArrayList;

public class MetroTicketView {
	private Stage stage = new Stage();
	private ChoiceBox<Integer> IDs = new ChoiceBox<>();
	private ObservableList<Integer> metroCardsIDs;
	private Button addCard;
	private Button addRides;
	private Button confirm;
	private Button cancel;
	private Label infoText;
	private Label infoPrice;


	public MetroTicketView(MetroTicketViewController metroTicketViewController) throws BiffException, IOException {
		metroTicketViewController.setView(this);
		stage.setTitle("METROTICKET VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(5);
		stage.setY(5);
		Group root = new Group();
		Scene scene = new Scene(root, 650, 400);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();

		VBox vBox = new VBox();
		vBox.setSpacing(10);
		root.getChildren().add(vBox);

		addCard = new Button("NEW METRO CARD");
		infoText = new Label("Metro card price is 15 euros - 2 free rides included");
		VBox deel1 = new VBox(addCard, infoText);
		setStyle(deel1);
		vBox.getChildren().add(deel1);


		Label selectText = new Label("Select metro card:");
		HBox hb1 = new HBox(selectText,IDs);
		hb1.setSpacing(10);

		Label numberText = new Label("Number of rides");
		TextField numberField = new TextField();
		HBox hb2 = new HBox(numberText,numberField);
		hb2.setSpacing(10);

		Label typeStudent = new Label("Higher education student?");
		CheckBox checkBox = new CheckBox("Yes");
		HBox hb3 = new HBox(typeStudent,checkBox);
		hb3.setSpacing(10);

		ToggleGroup group = new ToggleGroup();

		RadioButton rb1 = new RadioButton("Younger that 26 years");
		rb1.setToggleGroup(group);
		rb1.setSelected(true);

		RadioButton rb2 = new RadioButton("older than 64 years");
		rb2.setToggleGroup(group);

		RadioButton rb3 = new RadioButton("between 26 and 64 years");
		rb3.setToggleGroup(group);

		HBox hb4 = new HBox(rb1,rb2,rb3);
		hb4.setSpacing(10);

		addRides = new Button("Add extra rides to metro card");

		Label totalPrice = new Label("Total price:");
		TextField priceField = new TextField();
		HBox hb5 = new HBox(totalPrice,priceField);
		hb5.setSpacing(10);

		infoPrice = new Label("Price info");

		confirm = new Button("Confirm request");
		cancel = new Button("Cancel request");
		HBox hb6 = new HBox(confirm,cancel);
		hb6.setSpacing(10);

		VBox deel3indeel2 = new VBox(addRides,hb5, infoPrice,hb6);
		setStyle(deel3indeel2);

		VBox deel2 = new VBox(hb1,hb2, hb3,hb4,deel3indeel2);
		deel2.setSpacing(10);
		setStyle(deel2);
		vBox.getChildren().add(deel2);

		addCard.setOnAction(event -> {
			try {
				metroTicketViewController.buyMetroCards();
			} catch (IOException | BiffException e) {
				e.printStackTrace();
			}
		});
	}
	public void setStyle(VBox vBox){
		vBox.setStyle("-fx-border-color: black;-fx-border-radius: 3px ;-fx-border-width: 1px; -fx-border-style: solid; -fx-padding: 10px 200px 10px 10px; -fx-background-color: #C6CBCE;");
	}

	public void updateDropdownIDs(ArrayList<Integer> ids) {
		metroCardsIDs = FXCollections.observableArrayList(ids);
		IDs.setItems(metroCardsIDs);
	}


}
