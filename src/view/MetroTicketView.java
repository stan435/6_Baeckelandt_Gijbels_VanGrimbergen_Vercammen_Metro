package view;

import controller.MetroTicketViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
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
	private CheckBox checkBox;
	private VBox deel1,deel2,deel3indeel2;
	private TextField priceField, numberField;
	private RadioButton rb3;


	public MetroTicketView(MetroTicketViewController metroTicketViewController){
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

		VBox main = new VBox();
		main.setSpacing(10);
		root.getChildren().add(main);

		addCard = new Button("NEW METRO CARD");
		infoText = new Label("Metro card price is 15 euros - 2 free rides included");
		deel1 = new VBox(addCard, infoText);
		disableNodes(deel1);
		setStyle(deel1);
		main.getChildren().add(deel1);


		Label selectText = new Label("Select metro card:");
		HBox selectCard = new HBox(selectText,IDs);
		selectCard.setSpacing(10);

		Label numberText = new Label("Number of rides");
		numberField = new TextField();
		HBox numberRides = new HBox(numberText,numberField);
		numberRides.setSpacing(10);

		Label typeStudent = new Label("Higher education student?");
		checkBox = new CheckBox("Yes");
		HBox higherEducation = new HBox(typeStudent,checkBox);
		higherEducation.setSpacing(10);

		ToggleGroup group = new ToggleGroup();

		RadioButton rb1 = new RadioButton("Younger that 26 years");
		rb1.setToggleGroup(group);

		RadioButton rb2 = new RadioButton("older than 64 years");
		rb2.setToggleGroup(group);

		rb3 = new RadioButton("between 26 and 64 years");
		rb3.setToggleGroup(group);
		rb3.setSelected(true);

		HBox radioButtons = new HBox(rb1,rb2,rb3);
		radioButtons.setSpacing(10);

		addRides = new Button("Add extra rides to metro card");


		Label totalPrice = new Label("Total price:");
		priceField = new TextField();
		HBox hb5 = new HBox(totalPrice,priceField);
		hb5.setSpacing(10);

		infoPrice = new Label("Price info");

		confirm = new Button("Confirm request");
		confirm.setOnAction(event -> {
			try {
				metroTicketViewController.confirmRequest(IDs.getValue(), numberField.getText(),  priceField.getText() );
			} catch (BiffException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		});
		cancel = new Button("Cancel request");
		cancel.setOnAction(event -> resetForm());
		HBox hb6 = new HBox(confirm,cancel);
		hb6.setSpacing(10);

		deel3indeel2 = new VBox(addRides,hb5, infoPrice,hb6);
		disableNodes(deel3indeel2);
		setStyle(deel3indeel2);

		deel2 = new VBox(selectCard,numberRides, higherEducation,radioButtons,deel3indeel2);
		disableNodes(deel2);
		deel2.setSpacing(10);
		setStyle(deel2);
		main.getChildren().add(deel2);

		addCard.setOnAction(event -> {
			try {
				metroTicketViewController.buyMetroCards();
			} catch (IOException | BiffException e) {
				e.printStackTrace();
			}
		});

		addRides.setOnAction(event -> {
			Boolean isStudent = false;
			Boolean is26min = false;
			Boolean is64Plus = false;
			if(checkBox.isSelected()){
				isStudent= true;
			}
			if(rb1.isSelected()){
				is26min = true;
			}
			if(rb2.isSelected()){
				is64Plus = true;
			}
			try {
				metroTicketViewController.getPriceAndText(is26min, is64Plus, isStudent,metroTicketViewController.getMetrocard(String.valueOf(IDs.getValue())), Integer.parseInt(numberField.getText()));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (BiffException e) {
				e.printStackTrace();
			} catch (WriteException e) {
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

	public void openMetroStation(ArrayList<Integer> ids){
		enableNodes(deel1);
		enableNodes(deel2);
		enableNodes(deel3indeel2);
		updateDropdownIDs(ids);

	}

	public void closeMetrostation(){
		disableNodes(deel2);
		disableNodes(deel1);
		disableNodes(deel3indeel2);
	}

	public void enableNodes(VBox vBox){
		for (int i = 0; i < vBox.getChildren().size(); i++) {
			vBox.getChildren().get(i).setDisable(false);
		}

	}
	public void disableNodes(VBox vBox) {
		for (int i = 0; i < vBox.getChildren().size(); i++) {
			vBox.getChildren().get(i).setDisable(true);
		}
	}

	public void addTotalPriceText(String text){
		infoPrice.setText(text);
	}

	public void addTotalprice(double text){
		priceField.setText(String.format("%.2f",text).toString().replaceAll(",", "."));
	}

	public void resetForm(){
		IDs.setValue(null);
		numberField.setText("0");
		checkBox.setSelected(false);
		rb3.setSelected(true);
		priceField.setText(null);
		infoPrice.setText(null);
	}



}
