package Opgave1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

public class AdministrationGUI extends Application {
    Stage stage;

    public void start (Stage stage) {
        stage.setTitle("Person Administration");
        GridPane pane = new GridPane();

        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        this.stage = stage;



    }

    //-------------------------------------------------------------------

    //Fields
    PersonInformationWindow inputWindow;

    ListView<String> lstPersons = new ListView<>();

    ArrayList<String> personList = new ArrayList<>();

    Button btnNewPerson = new Button("Add Person");

    Label lblPersons = new Label("Persons:");


    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setVgap(10);
        pane.setHgap(10);

        pane.add(lblPersons,0,0);

        pane.add(lstPersons,1,0,2,3);
        lstPersons.setPrefHeight(200);
        lstPersons.getItems().setAll(personList);

        pane.add(btnNewPerson,3,1);
        btnNewPerson.setOnAction(event -> addNewPersonAction());

    }

    public void addNewPersonAction () {
        inputWindow = new PersonInformationWindow(stage);
        inputWindow.showAndWait();

        if (inputWindow.getPersonToAdd() != null) {
            Person newPerson = inputWindow.getPersonToAdd();
            personList.add(newPerson.toString());
            lstPersons.getItems().setAll(personList);
        }
    }




}
