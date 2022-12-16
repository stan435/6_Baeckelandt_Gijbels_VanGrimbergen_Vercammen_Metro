package view.panels;


import controller.ControlCenterPaneController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import jxl.read.biff.BiffException;
import jxl.write.DateTime;
import jxl.write.WriteException;
import model.database.MetroCardDatabase;


import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControlCenter extends GridPane {

    private Label numberSoldTickets,totalPriceSoldTickets,gateTitel1,amountScannedCards1,gateTitel2,amountScannedCards2,
            gateTitel3,amountScannedCards3,alertTitel,alerts;
    private HBox hBox1,hBox2,gates;
    private VBox child1,child2,gate1,gate2,gate3,child3,child4,parent;
    private Button Active1,Deactive1,Active2,Deactive2,Active3,Deactive3,open, close;
    private MetroCardDatabase metroCardDatabase = new MetroCardDatabase();
    private TextField amount1, amount2, amount3, number, price;

    public ControlCenter(ControlCenterPaneController controlCenterPaneController){
        controlCenterPaneController.setView(this);

        open = new Button("Open Metro Station");
        open.setOnAction(event -> {
            enableNodes(gate1,amount1);
            enableNodes(gate2,amount2);
            enableNodes(gate3,amount3);
            close.setDisable(false);
            try {
                controlCenterPaneController.openMetroStation();
            } catch (BiffException | IOException e) {
                e.printStackTrace();
            }
        });

        close = new Button("Close Metro Station");
        close.setDisable(true);
        close.setOnAction(event -> {
            disableNodes(gate1);
            disableNodes(gate2);
            disableNodes(gate3);
            close.setDisable(true);
            try {
                controlCenterPaneController.closeMetroStation();
            } catch (BiffException | IOException | WriteException e) {
                e.printStackTrace();
            }
        });


        child1 = new VBox(open, close);

        numberSoldTickets = new Label("Number of sold tickets: ");
        number = new TextField("0");
        hBox1 = new HBox(numberSoldTickets,number);

        totalPriceSoldTickets = new Label("Total $ amount of sold tickets: ");
        price = new TextField("0");
        hBox2 = new HBox(totalPriceSoldTickets,price);

        child2 = new VBox(hBox1,hBox2);
        child2.setSpacing(10);


        gateTitel1 = new Label("GATE 1 ACTIVE/INACTIVE (NOG PROGRAMMEREN)");
        Active1 = new Button("Activate");
        Deactive1 = new Button("Deactivate");
        amountScannedCards1 = new Label("# scanned cards");
        amount1 = new TextField("0");
        gate1 = new VBox(gateTitel1,Active1,Deactive1,amountScannedCards1,amount1);
        gate1.setId("1");

        disableNodes(gate1);

        Active1.setOnAction(event -> activate(controlCenterPaneController,gate1,1));
        Deactive1.setOnAction(event -> deactivate(controlCenterPaneController,gate1,1));



        gateTitel2 = new Label("GATE 2 ACTIVE/INACTIVE (NOG PROGRAMMEREN)");
        Active2 = new Button("Activate");
        Deactive2 = new Button("Deactivate");
        amountScannedCards2 = new Label("# scanned cards");
        amount2 = new TextField("0");
        gate2 = new VBox(gateTitel2,Active2,Deactive2,amountScannedCards2,amount2);
        gate2.setId("2");
        disableNodes(gate2);

        Active2.setOnAction(event -> activate(controlCenterPaneController,gate2,2));
        Deactive2.setOnAction(event -> deactivate(controlCenterPaneController,gate2,2));

        gateTitel3 = new Label("GATE 3 ACTIVE/INACTIVE (NOG PROGRAMMEREN)");
        Active3 = new Button("Activate");
        Deactive3 = new Button("Deactivate");
        amountScannedCards3 = new Label("# scanned cards");
        amount3 = new TextField("0");
        gate3 = new VBox(gateTitel3,Active3,Deactive3,amountScannedCards3,amount3);
        gate3.setId("3");
        disableNodes(gate3);

        Active3.setOnAction(event -> activate(controlCenterPaneController,gate3,3));
        Deactive3.setOnAction(event -> deactivate(controlCenterPaneController,gate3,3));


        gates = new HBox(gate1,gate2,gate3);
        gates.setSpacing(10);

        child3 = new VBox(gates);
        child3.setSpacing(10);


        alertTitel = new Label("ALERTS");
        alerts = new Label("");
        alerts.setId("alert");
        child4 = new VBox(alertTitel);

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

    public void addAllert(String gatId){
        DateTimeFormatter f =DateTimeFormatter.ofPattern("HH:mm");
        String date = f.format(LocalDateTime.now());
        String s = date +" UNATHORIZED passage GATE " + gatId + "\n" + alerts.getText();
        child4.getChildren().remove(alerts);
        alerts = new Label(s);
        child4.getChildren().add(alerts);
    }

    public void styleOpenOnId(String id){
        VBox vBox = (VBox) this.lookup("#" + id);
        vBox.setStyle("-fx-spacing: 10; -fx-padding: 5 0 5 5; -fx-background-color: #02f8b6; -fx-pref-height: 200; -fx-pref-width: 500; -fx-border-radius: 1px; -fx-border-color: black;");
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

    public void updateGateScannedCards(String gateId){
        VBox vBox = (VBox) this.lookup("#" + gateId);
        TextField textField = (TextField) vBox.getChildren().get(4);
        int amount = Integer.parseInt(textField.getText());
        amount++;
        textField.setText(Integer.toString(amount));
    }

    public void enableNodes(VBox vBox, Node... exception){
        for (int i = 0; i < vBox.getChildren().size(); i++) {
            if(vBox.getChildren().get(i) != exception[0])
                vBox.getChildren().get(i).setDisable(false);
        }
    }

    public void disableNodes(VBox vBox) {
        for (int i = 0; i < vBox.getChildren().size(); i++) {
            vBox.getChildren().get(i).setDisable(true);
        }
    }

    public void activate(ControlCenterPaneController controlCenterPaneController, VBox gate, int gatId){
        styleOpen(gate);
        try {
            controlCenterPaneController.activateGate(gatId);
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deactivate(ControlCenterPaneController controlCenterPaneController, VBox gate, int gatId){
        styleClosed(gate);
        try {
            controlCenterPaneController.deactivateGate(gatId);
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateTicketNumberFields(String soldTickets, String TotalSoldPrice){
        int numberSold = Integer.parseInt(number.getText());
        double priceSold = Double.parseDouble(price.getText());
        int megekregenSold = Integer.parseInt(soldTickets);
        double megekregenPrice = Double.parseDouble(TotalSoldPrice);
        numberSold += megekregenSold;
        priceSold += megekregenPrice;
        number.setText(String.valueOf(numberSold));
        price.setText(String.valueOf(priceSold));
    }



/*
    public ArrayList<Node> createGate(int gateId){
        ArrayList<Node> nodes = new ArrayList<>();
        Label gateTitel = new Label("GATE " + gateId + " ACTIVE/INACTIVE (NOG PROGRAMMEREN)");
        Button activate = new Button("Activate");
        Button deactivate = new Button("Deactivate");
        Label scannedCardsLabel = new Label("# scanned cards");
        TextField scannedCardsAmount = new TextField("0");
        VBox gate = new VBox(gateTitel,activate,deactivate,scannedCardsLabel,scannedCardsAmount);
        disableNodes(gate);
        for (int i = 0; i < gate.getChildren().size(); i++) {
            nodes.add(gate.getChildren().get(i));
        }
        return nodes;
    }

 */


}

