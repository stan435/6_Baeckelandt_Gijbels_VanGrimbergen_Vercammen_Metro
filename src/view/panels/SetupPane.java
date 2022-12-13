package view.panels;

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

public class SetupPane extends VBox {
    private ChoiceBox<String> strategy;
    private Button save;
    private ClickHandler clickHandler;
    private MetroCardDatabase metroCardDatabase = new MetroCardDatabase();


    public SetupPane() {


        clickHandler = new ClickHandler();

        strategy = new ChoiceBox<>();
        Label tekstLabel = new Label("kies strategy");
        strategy.getItems().addAll("Tekst", "Excel");
        strategy.setValue("Tekst");

        save = new Button("save");
        save.setOnAction(clickHandler);
        save.setAlignment(Pos.CENTER_RIGHT);


        this.getChildren().add(strategy);
        this.getChildren().add(save);
    }

    private class ClickHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Properties properties = new Properties();
            try {
                FileInputStream os = new FileInputStream("./bestanden/settings.properties");
                properties.load(os);
                properties.setProperty("strategy", strategy.getValue());
                FileOutputStream naam = new FileOutputStream("./bestanden/settings.properties");
                properties.store(naam,"Strategy");
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

