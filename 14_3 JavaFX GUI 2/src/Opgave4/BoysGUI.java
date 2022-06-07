package Opgave4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BoysGUI extends Application {
    public void start (Stage stage) {
        stage.setTitle("Boys");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    //---------------------

    //Fields
    Label lblList = new Label("Names:");
    Label lblNewName = new Label("Name");

    ArrayList<String> listOfBoys = new ArrayList<>();
    ArrayList<String> listOfGirls = new ArrayList<>();
    ListView<String> lstNames = new ListView<>();

    TextField txtNewName = new TextField();

    Button btnAdd = new Button("Add");

    ToggleGroup radioGroup = new ToggleGroup();


    public void initContent (GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(lblList,0,1);
        pane.add(lstNames, 1,1,2,3);
        lstNames.getItems().setAll(listOfBoys);

        pane.add(lblNewName,0,4);
        pane.add(txtNewName,1,4,2,1);

        pane.add(btnAdd, 3, 4);
        btnAdd.setOnAction(event -> addToListAction());

        HBox horizontalBox = new HBox();
        RadioButton rbBoys = new RadioButton("Boys");
        RadioButton rbGirls = new RadioButton("Girls");
        horizontalBox.getChildren().add(rbBoys);
        horizontalBox.getChildren().add(rbGirls);
        rbBoys.setToggleGroup(radioGroup);
        rbGirls.setToggleGroup(radioGroup);
        pane.add(horizontalBox, 0,0);

        rbBoys.setOnAction(event -> setListAction());
        rbGirls.setOnAction(event -> setListAction());

        radioGroup.selectToggle(rbBoys);
        lstNames.getItems().setAll(listOfBoys);

    }

    public void setListAction() {
        if (radioGroup.getSelectedToggle().equals(radioGroup.getToggles().get(0))) {
            lstNames.getItems().setAll(listOfBoys);
        } else {
            lstNames.getItems().setAll(listOfGirls);
        }
    }

    public void addToListAction() {
        if (radioGroup.getSelectedToggle().equals(radioGroup.getToggles().get(0))) {
            listOfBoys.add(txtNewName.getText().trim());
            lstNames.getItems().setAll(listOfBoys);
        } else {
            listOfGirls.add(txtNewName.getText().trim());
            lstNames.getItems().setAll(listOfGirls);
        }
        txtNewName.clear();
    }
}
