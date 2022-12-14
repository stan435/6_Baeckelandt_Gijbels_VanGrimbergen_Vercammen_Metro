package view.panels;


import controller.ControlCenterPaneController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import jxl.read.biff.BiffException;
import model.database.MetroCardDatabase;


import java.io.IOException;

public class ControlCenter extends GridPane {

    private Label numberSoldTickets,number,totalPriceSoldTickets,price,gateTitel1,amountScannedCards1,amount1,gateTitel2,amountScannedCards2,amount2,
            gateTitel3,amountScannedCards3,amount3,alertTitel,alerts;
    private HBox hBox1,hBox2,gates;
    private VBox child1,child2,gate1,gate2,gate3,child3,child4,parent;
    private Button Active1,Deactive1,Active2,Deactive2,Active3,Deactive3,open;
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


        child1 = new VBox(open);

        numberSoldTickets = new Label("Number of sold tickets: ");
        number = new Label("DIT NOG PROGRAMMEREN");
        hBox1 = new HBox(numberSoldTickets,number);

        totalPriceSoldTickets = new Label("Total $ amount of sold tickets: ");
        price = new Label("DIT NOG PROGRAMMEREN");
        hBox2 = new HBox(totalPriceSoldTickets,price);

        child2 = new VBox(hBox1,hBox2);
        child2.setSpacing(10);

        gateTitel1 = new Label("GATE 1 ACTIVE/INACTIVE (NOG PROGRAMMEREN)");
        Active1 = new Button("Activate");
        Active1.setOnAction(event -> {
            styleOpen(gate1);
        });
        Deactive1 = new Button("Deactivate");
        Deactive1.setOnAction(event -> {
            styleClosed(gate1);
        });
        amountScannedCards1 = new Label("# scanned cards");
        amount1 = new Label("NOG PROGRAMMEREN");
        gate1 = new VBox(gateTitel1,Active1,Deactive1,amountScannedCards1,amount1);

        gateTitel2 = new Label("GATE 2 ACTIVE/INACTIVE (NOG PROGRAMMEREN)");
        Active2 = new Button("Activate");
        Active2.setOnAction(event -> {
            styleOpen(gate2);
        });
        Deactive2 = new Button("Deactivate");
        Deactive2.setOnAction(event -> {
            styleClosed(gate2);
        });
        amountScannedCards2 = new Label("# scanned cards");
        amount2 = new Label("NOG PROGRAMMEREN");
        gate2 = new VBox(gateTitel2,Active2,Deactive2,amountScannedCards2,amount2);

        gateTitel3 = new Label("GATE 3 ACTIVE/INACTIVE (NOG PROGRAMMEREN)");
        Active3 = new Button("Activate");
        Active3.setOnAction(event -> {
            styleOpen(gate3);
        });
        Deactive3 = new Button("Deactivate");
        Deactive3.setOnAction(event -> {
            styleClosed(gate3);
        });
        amountScannedCards3 = new Label("# scanned cards");
        amount3 = new Label("NOG PROGRAMMEREN");
        gate3 = new VBox(gateTitel3,Active3,Deactive3,amountScannedCards3,amount3);

        gates = new HBox(gate1,gate2,gate3);
        gates.setSpacing(10);

        child3 = new VBox(gates);
        child3.setSpacing(10);


        alertTitel = new Label("ALERTS");
        alerts = new Label("00:00 VOORBEELDALERT 1\n 00:00 VOORBEELDALERT 2\n 00:00 VOORBEELDALERT 3");
        child4 = new VBox(alertTitel,alerts);

        parent = new VBox(child1,child2,child3,child4);
        parent.setSpacing(10);

        setStyle(child1);
        setStyle(child2);
        setStyle(child3);
        setStyle(child4);
        styleClosed(gate1);
        styleClosed(gate2);
        styleClosed(gate3);


        this.getChildren().add(parent);
    }

    public void styleClosed(VBox vBox) {
        vBox.setStyle("-fx-spacing: 10; -fx-padding: 5 0 5 5; -fx-background-color: #f81e1e; -fx-pref-height: 200; -fx-pref-width: 500; -fx-border-radius: 1px; -fx-border-color: black;");
    }

    public void styleOpen(VBox vBox) {
        vBox.setStyle("-fx-spacing: 10; -fx-padding: 5 0 5 5; -fx-background-color: #02f8b6; -fx-pref-height: 200; -fx-pref-width: 500; -fx-border-radius: 1px; -fx-border-color: black;");
    }

    public void setStyle(VBox vBox){
        vBox.setStyle("-fx-border-color: black;-fx-border-radius: 3px ;-fx-border-width: 1px; -fx-border-style: solid; -fx-padding: 10px 10px 10px 10px; -fx-background-color: #C6CBCE;");
    }




private class ClickHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

    }
    }
}

