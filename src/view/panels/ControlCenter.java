package view.panels;


import controller.ControlCenterPaneController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
import jxl.read.biff.BiffException;
import model.database.MetroCardDatabase;


import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
public class ControlCenter extends GridPane {

    private Button open;
    private ClickHandler clickHandler;
    private MetroCardDatabase metroCardDatabase = new MetroCardDatabase();
    private ControlCenterPaneController controlCenterPaneController = new ControlCenterPaneController();

    public ControlCenter(){
        clickHandler = new ClickHandler();

        open = new Button("Open Metro Station");
        open.setOnAction(clickHandler);
        open.setAlignment(Pos.CENTER_RIGHT);

        this.getChildren().add(open);
    }



private class ClickHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        try {
            controlCenterPaneController.openMetroStation();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
}

