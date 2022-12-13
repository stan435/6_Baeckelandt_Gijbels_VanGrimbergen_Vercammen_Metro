package view;

import com.sun.security.ntlm.Client;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jxl.read.biff.BiffException;
import model.MetroFacade;

import java.io.IOException;

public class AdminView {
	private Stage stage = new Stage();
		
	public AdminView(MetroFacade metroFacade) throws IOException, BiffException {
		stage.setTitle("ADMIN VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(660);
		stage.setY(5);
		Group root = new Group();
		Scene scene = new Scene(root, 690, 680);
		BorderPane borderPane = new AdminMainPane(metroFacade);
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(borderPane);
		scene.getStylesheets().add(AdminView.class.getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}
}
