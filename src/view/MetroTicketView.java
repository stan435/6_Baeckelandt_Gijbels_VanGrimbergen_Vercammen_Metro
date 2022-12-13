package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;	

public class MetroTicketView {
	private Stage stage = new Stage();		
		
	public MetroTicketView(){			
		stage.setTitle("METROTICKET VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(5);
		stage.setY(5);
		Group root = new Group();
		Scene scene = new Scene(root, 650, 350);			
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();
		VBox ticketView1 = ticketView1();
		root.getChildren().add(ticketView1);


	}
	public VBox ticketView1(){
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10, 10, 10, 10));
		vBox.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-border-style: solid; -fx-padding: 10px 340px 10px 10px; -fx-background-color: #C6CBCE;");

		vBox.getChildren().add(new Button("NEW METRO CARD"));
		vBox.getChildren().add(new Label("Metro card price is 15 euros - 2 free rides included"));
		return vBox;
	}
}
