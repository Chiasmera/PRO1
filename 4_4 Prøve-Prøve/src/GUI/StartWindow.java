package GUI;

import Application.Controller.Controller;
import Application.Model.Område;
import Application.Model.Plads;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class StartWindow extends Application{

    private ListView<Plads> lvwPladser;
    private TextField txfNummer;
    private RadioButton rbStandard;
    private RadioButton rbVIP;
    private RadioButton rbBørne ;
    private RadioButton rbTurnering;

    private ToggleGroup tglGroup;

    public void init () {
        Controller.initStorage();
    }

    @Override
    public void start(Stage stage) throws Exception {


        stage.setTitle("Netcafe administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void initContent (GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblPladser = new Label("Pladser");
        pane.add(lblPladser,0,0);

        lvwPladser = new ListView<>();
        lvwPladser.setPrefHeight(200);
        pane.add(lvwPladser,0,1,2,1);

        Label lblOmråde = new Label("Område");
        pane.add(lblOmråde, 0, 2);

        ArrayList<RadioButton> rbbtns = new ArrayList<>();
        RadioButton rbStandard = new RadioButton("Standard");
        RadioButton rbVIP = new RadioButton("VIP");
        RadioButton rbBørne = new RadioButton("Børne");
        RadioButton rbTurnering = new RadioButton("Turnering");

        rbbtns.add(rbStandard);
        rbbtns.add(rbBørne);
        rbbtns.add(rbTurnering);
        rbbtns.add(rbVIP);

        tglGroup = new ToggleGroup();
        VBox radiobuttons = new VBox(5);

        for (RadioButton rb : rbbtns) {
            rb.setToggleGroup(tglGroup);
            radiobuttons.getChildren().add(rb);
        }

        tglGroup.selectToggle(rbStandard);

        pane.add(radiobuttons, 1,2);

        Label lblNummer = new Label("Nummer");
        pane.add(lblNummer, 0, 3);

        txfNummer = new TextField();
        pane.add(txfNummer,1,3);

        Button btnOpret = new Button("Opret");
        pane.add(btnOpret,1,4);
        btnOpret.setOnAction(event -> opretPladsAction());


        updatePladser();
    }

    public void opretPladsAction() {
        int nr = Integer.parseInt(txfNummer.getText());
        Område område;
        if (tglGroup.getSelectedToggle() == tglGroup.getToggles().get(0)) {
            område = Område.STANDARD;
        } else if (tglGroup.getSelectedToggle() == tglGroup.getToggles().get(1)) {
            område = Område.VIP;
        } else if (tglGroup.getSelectedToggle() == tglGroup.getToggles().get(2)) {
            område = Område.BØRNE;
        }else {
            område = Område.TURNERING;
        }

        Controller.createPlads(nr,område);
        updatePladser();
        txfNummer.clear();;
    }

    public void updatePladser () {
        lvwPladser.getItems().setAll(Controller.getPladser());
        if (Controller.getPladser().size() > 0) {
            lvwPladser.getSelectionModel().selectFirst();
        }
    }
}
