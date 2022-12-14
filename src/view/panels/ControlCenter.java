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
import javafx.scene.layout.HBox;
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

    public ControlCenter(ControlCenterPaneController controlCenterPaneController){
        clickHandler = new ClickHandler();

        open = new Button("Open Metro Station");
        open.setOnAction(event -> {
            try {
                controlCenterPaneController.openMetroStation();
            } catch (BiffException | IOException e) {
                e.printStackTrace();
            }
        });


        VBox child1 = new VBox(open);

        Label numberSoldTickets = new Label("Number of sold tickets:");
        Label number = new Label("DIT NOG PROGRAMMEREN");
        HBox hBox1 = new HBox(numberSoldTickets,number);

        Label totalPriceSoldTickets = new Label("Total $ amount of sold tickets");
        Label price = new Label("DIT NOG PROGRAMMEREN");
        HBox hBox2 = new HBox(totalPriceSoldTickets,price);

        VBox child2 = new VBox(hBox1,hBox2);
        child2.setSpacing(10);

        Label gateTitel1 = new Label("GATE 1 ACTIVE/INACTIVE (NOG PROGRAMMEREN)");
        Button Active1 = new Button("Activate");
        Button Deactive1 = new Button("Deactivate");
        Label amountScannedCards1 = new Label("# scanned cards");
        Label amount1 = new Label("NOG PROGRAMMEREN");
        VBox gate1 = new VBox(gateTitel1,Active1,Deactive1,amountScannedCards1,amount1);

        Label gateTitel2 = new Label("GATE 2 ACTIVE/INACTIVE (NOG PROGRAMMEREN)");
        Button Active2 = new Button("Activate");
        Button Deactive2 = new Button("Deactivate");
        Label amountScannedCards2 = new Label("# scanned cards");
        Label amount2 = new Label("NOG PROGRAMMEREN");
        VBox gate2 = new VBox(gateTitel2,Active2,Deactive2,amountScannedCards2,amount2);

        Label gateTitel3 = new Label("GATE 3 ACTIVE/INACTIVE (NOG PROGRAMMEREN)");
        Button Active3 = new Button("Activate");
        Button Deactive3 = new Button("Deactivate");
        Label amountScannedCards3 = new Label("# scanned cards");
        Label amount3 = new Label("NOG PROGRAMMEREN");
        VBox gate3 = new VBox(gateTitel3,Active3,Deactive3,amountScannedCards3,amount3);

        HBox gates = new HBox(gate1,gate2,gate3);

        VBox child3 = new VBox(gates);
        child3.setSpacing(10);


        Label alertTitel = new Label("ALERTS");
        Label alerts = new Label("00:00 VOORBEELDALERT 1\n 00:00 VOORBEELDALERT 2\n 00:00 VOORBEELDALERT 3");
        VBox child4 = new VBox(alertTitel,alerts);

        VBox parent = new VBox(child1,child2,child3,child4);
        parent.setSpacing(10);

        this.getChildren().add(parent);

    }



private class ClickHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

    }
    }
}

