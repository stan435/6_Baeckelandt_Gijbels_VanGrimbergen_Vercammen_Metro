package view;

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
		root.getChildren().add(ticketView1());
		

	}
	public VBox ticketView1(){
		VBox vBox = new VBox();

		vBox.getChildren().add(new Button("new Metro card"));
		vBox.getChildren().add(new Label("nieuwe label super cool"));
		return vBox;
	}
}
