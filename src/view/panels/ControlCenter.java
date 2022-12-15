package view.panels;


import controller.ControlCenterPaneController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import jxl.read.biff.BiffException;
import jxl.write.DateTime;
import model.database.MetroCardDatabase;


import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ControlCenter extends GridPane {

    private Label numberSoldTickets,number,totalPriceSoldTickets,price,gateTitel1,amountScannedCards1,gateTitel2,amountScannedCards2,
            gateTitel3,amountScannedCards3,alertTitel,alerts;
    private HBox hBox1,hBox2,gates;
    private VBox child1,child2,gate1,gate2,gate3,child3,child4,parent;
    private Button Active1,Deactive1,Active2,Deactive2,Active3,Deactive3,open;
    private ClickHandler clickHandler;
    private MetroCardDatabase metroCardDatabase = new MetroCardDatabase();
    private TextField amount1, amount2, amount3;

    public ControlCenter(ControlCenterPaneController controlCenterPaneController){
        controlCenterPaneController.setView(this);
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
            try {
                controlCenterPaneController.activateGate(1);
            } catch (BiffException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Deactive1 = new Button("Deactivate");
        Deactive1.setOnAction(event -> {
            styleClosed(gate1);
            try {
                controlCenterPaneController.deactivateGate(1);
            } catch (BiffException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        amountScannedCards1 = new Label("# scanned cards");
        amount1 = new TextField("0");
        amount1.setDisable(true);
        gate1 = new VBox(gateTitel1,Active1,Deactive1,amountScannedCards1,amount1);

        gateTitel2 = new Label("GATE 2 ACTIVE/INACTIVE (NOG PROGRAMMEREN)");
        Active2 = new Button("Activate");
        Active2.setOnAction(event -> {
            styleOpen(gate2);
            try {
                controlCenterPaneController.activateGate(2);
            } catch (BiffException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Deactive2 = new Button("Deactivate");
        Deactive2.setOnAction(event -> {
            styleClosed(gate2);
            try {
                controlCenterPaneController.deactivateGate(2);
            } catch (BiffException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        amountScannedCards2 = new Label("# scanned cards");
        amount2 = new TextField("0");
        amount2.setDisable(true);
        gate2 = new VBox(gateTitel2,Active2,Deactive2,amountScannedCards2,amount2);

        gateTitel3 = new Label("GATE 3 ACTIVE/INACTIVE (NOG PROGRAMMEREN)");
        Active3 = new Button("Activate");
        Active3.setOnAction(event -> {
            styleOpen(gate3);
            try {
                controlCenterPaneController.activateGate(3);
            } catch (BiffException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Deactive3 = new Button("Deactivate");
        Deactive3.setOnAction(event -> {
            styleClosed(gate3);
            try {
                controlCenterPaneController.deactivateGate(3);
            } catch (BiffException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        amountScannedCards3 = new Label("# scanned cards");
        amount3 = new TextField("0");
        amount3.setDisable(true);
        gate3 = new VBox(gateTitel3,Active3,Deactive3,amountScannedCards3,amount3);

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

    public void addAlter(String gatId){
        DateTimeFormatter f =DateTimeFormatter.ofPattern("HH:mm");
        String date = f.format(LocalDateTime.now());
        String s = date +" UNATHORIZED passage GATE " + gatId + "\n" + alerts.getText();
        child4.getChildren().remove(alerts);
        alerts = new Label(s);
        child4.getChildren().add(alerts);
    }

    public void styleOpenOnId(String id){
        if(id.equals("1")){
            gate1.setStyle("-fx-spacing: 10; -fx-padding: 5 0 5 5; -fx-background-color: #02f8b6; -fx-pref-height: 200; -fx-pref-width: 500; -fx-border-radius: 1px; -fx-border-color: black;");
        }
        if(id.equals("2")){
            gate2.setStyle("-fx-spacing: 10; -fx-padding: 5 0 5 5; -fx-background-color: #02f8b6; -fx-pref-height: 200; -fx-pref-width: 500; -fx-border-radius: 1px; -fx-border-color: black;");
        }
        if(id.equals("3")){
            gate3.setStyle("-fx-spacing: 10; -fx-padding: 5 0 5 5; -fx-background-color: #02f8b6; -fx-pref-height: 200; -fx-pref-width: 500; -fx-border-radius: 1px; -fx-border-color: black;");
        }
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
        if(gateId.equals("1")){
           int amount = Integer.parseInt(amount1.getText());
           amount = amount += 1;
           amount1.setText(Integer.toString(amount));
        }
        if(gateId.equals("2")){
            int amount = Integer.parseInt(amount1.getText());
            amount = amount += 1;
            amount2.setText(Integer.toString(amount));        }
        if(gateId.equals("3")){
            int amount = Integer.parseInt(amount1.getText());
            amount = amount += 1;
            amount3.setText(Integer.toString(amount));        }
    }




private class ClickHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

    }
    }
}

