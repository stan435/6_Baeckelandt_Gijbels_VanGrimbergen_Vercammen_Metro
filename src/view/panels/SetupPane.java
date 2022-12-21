package view.panels;

import controller.SetupPaneController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class SetupPane extends VBox {
    private ChoiceBox<String> strategyBox;
    private Button save;
    private Button saveDiscount;
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
    private ClickHandler clickHandler;

    public SetupPane(SetupPaneController setupPaneController) {
        setupPaneController.setView(this);
        clickHandler = new ClickHandler();

        VBox main = new VBox();
        main.setSpacing(10);
        this.getChildren().add(main);

        VBox strategy = new VBox();
        strategy.setSpacing(10);
        setStyle(strategy);

        strategyBox = new ChoiceBox<>();
        strategyBox.getItems().addAll("Tekst", "Excel");
        strategyBox.setValue("Tekst");

        save = new Button("save");
        save.setOnAction(clickHandler);
        save.setAlignment(Pos.CENTER_RIGHT);

        VBox discount = new VBox();
        discount.setSpacing(5);
        setStyle(discount);
        Label studentDiscount = new Label("Higher education student discount");
        checkBox1 = new CheckBox("Yes");
        HBox hb1 = new HBox(studentDiscount,checkBox1);
        hb1.setSpacing(10);


        Label ChristmasLeaveDiscount = new Label("Christmas Leave Discount");
        checkBox2 = new CheckBox("Yes");
        HBox hb2 = new HBox(ChristmasLeaveDiscount,checkBox2);
        hb2.setSpacing(10);


        Label FrequentTravellerDiscount = new Label("Frequent Traveller Discount");
        checkBox3 = new CheckBox("Yes");
        HBox hb3 = new HBox(FrequentTravellerDiscount,checkBox3);
        hb3.setSpacing(10);


        Label Age64PlusDiscount = new Label("Age64 Plus Discount");
        checkBox4 = new CheckBox("Yes");
        HBox hb4 = new HBox(Age64PlusDiscount,checkBox4);
        hb4.setSpacing(10);

        saveDiscount = new Button("save discount");
        saveDiscount.setOnAction(event -> {
            Properties properties = new Properties();
            try {
                FileInputStream os = new FileInputStream("./bestanden/settings.properties");
                properties.load(os);
                ArrayList<String> list = new ArrayList<>();
                String discountString = "";
                if(checkBox1.isSelected()){
                    list.add("STUDENTDISCOUNT");
                }
                if(checkBox2.isSelected()){
                    list.add("CHRISTMASLEAVEDISCOUNT");
                }
                if(checkBox3.isSelected()){
                    list.add("FREQUENTTRAVELERDISCOUNT");
                }
                if(checkBox4.isSelected()){
                    list.add("AGE64PLUSDISCOUNT");
                }
                if(!list.isEmpty()){
                   discountString = String.join(",", list);
                }
                properties.setProperty("discount", discountString);
                FileOutputStream naam = new FileOutputStream("./bestanden/settings.properties");
                properties.store(naam,"Discount");
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        discount.getChildren().addAll(hb1,hb2,hb3,hb4,saveDiscount);

        main.getChildren().addAll(strategy,discount);

        strategy.getChildren().addAll(strategyBox,save);


    }

    public void updateCheckBox() throws IOException {
        Properties properties = new Properties();
        InputStream is = new FileInputStream("./bestanden/settings.properties");
        properties.load(is);
        String discount = properties.getProperty("discount");
        String[] list = discount.split(",");
        for (int i = 0; i < list.length; i++) {
            if(list[i].equals("STUDENTDISCOUNT")){
                checkBox1.setSelected(true);
            }
            if(list[i].equals("CHRISTMASLEAVEDISCOUNT")){
                checkBox2.setSelected(true);
            }
            if(list[i].equals("FREQUENTTRAVELERDISCOUNT")){
                checkBox3.setSelected(true);
            }
            if(list[i].equals("AGE64PLUSDISCOUNT")){
                checkBox4.setSelected(true);
            }
        }
    }

    public void setStyle(VBox vBox){
        vBox.setStyle("-fx-border-color: black;-fx-border-radius: 3px ;-fx-border-width: 1px; -fx-border-style: solid; -fx-padding: 10px 200px 10px 10px; -fx-background-color: #C6CBCE;");
    }

    private class ClickHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Properties properties = new Properties();
            try {
                FileInputStream os = new FileInputStream("./bestanden/settings.properties");
                properties.load(os);
                properties.setProperty("strategy", strategyBox.getValue());
                FileOutputStream naam = new FileOutputStream("./bestanden/settings.properties");
                properties.store(naam,"Strategy");
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

