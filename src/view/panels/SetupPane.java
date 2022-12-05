package view.panels;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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


import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SetupPane extends GridPane {
    private ChoiceBox<String> strategy;
    private Button save;
    private ClickHandler clickHandler;


    public SetupPane() {


        clickHandler = new ClickHandler();
        strategy = new ChoiceBox<>();
        Label tekstLabel = new Label("kies strategy");
        strategy.getItems().addAll("Tekst", "Excel");
        strategy.setValue("Tekst");
        save = new Button("save");
        save.setOnAction(clickHandler);
        save.setId("buttonSave");
        this.getChildren().add(strategy);
        this.getChildren().add(save);
    }

    private class ClickHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Properties properties = new Properties();
            FileOutputStream os = null;
            try {
                os = new FileOutputStream("./bestanden/settings.properties");
                properties.store(os, strategy.getValue());
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

