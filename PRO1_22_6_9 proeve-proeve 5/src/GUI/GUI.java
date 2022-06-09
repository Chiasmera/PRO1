package GUI;

import Application.Controller.Service;
import Application.Model.Kamp;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;


public class GUI extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Tutoradministration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    ListView<Kamp> lwKampe = new ListView<>();
    TextField txtSted = new TextField();
    TextField txtDato = new TextField();
    TextField txtTid = new TextField();
    Button btnOpret = new Button("Opret");
    Button btnOpdater = new Button("Opdater");
    Button btnLavFil = new Button("Lav Fil");

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblKampe = new Label("Kampe");
        pane.add(lblKampe, 0, 0);

        Label lblSted = new Label("Spillested:");
        pane.add(lblSted, 2, 0);

        Label lbldato = new Label("Spilledato:");
        pane.add(lbldato, 2, 1);

        Label lblTid = new Label("Spilletid:");
        pane.add(lblTid, 2, 2);

        pane.add(lwKampe, 0, 1, 2, 5);
        pane.add(txtSted, 3, 0, 2, 1);
        pane.add(txtDato, 3, 1, 2, 1);
        pane.add(txtTid, 3, 2, 2, 1);
        pane.add(btnOpret, 3, 3);
        pane.add(btnOpdater, 4, 3);
        pane.add(btnLavFil, 3, 4);

        ChangeListener<Kamp> listener = (ov, oldKamp, newKamp) -> this.updateSelected();
        lwKampe.getSelectionModel().selectedItemProperty().addListener(listener);

        btnOpret.setOnAction(actionEvent -> opretAction());
        btnOpdater.setOnAction(actionEvent -> opdaterAction());
        btnLavFil.setOnAction(actionEvent -> lavFilAction());

        Service.createSomeObjects();
        updateList();
        lwKampe.getSelectionModel().selectFirst();

    }

    public void updateList() {
        lwKampe.getItems().setAll(Service.getKampe());
    }

    public void updateSelected() {
        txtSted.setText(lwKampe.getSelectionModel().getSelectedItem().getSted());
        txtDato.setText(lwKampe.getSelectionModel().getSelectedItem().getDato().toString());
        txtTid.setText(lwKampe.getSelectionModel().getSelectedItem().getTid().toString());
    }

    public void opretAction() {
        if (txtSted.getText().isBlank() || txtDato.getText().isBlank() || txtTid.getText().isBlank()) {
            Alert emptyTextAlert = new Alert(Alert.AlertType.ERROR);
            emptyTextAlert.setContentText("One or more of the textfields are empty. You must provide both a place, a date and a time for the match");
            emptyTextAlert.setTitle("Empty Textbox");
            emptyTextAlert.showAndWait();
        } else {
            Service.createKamp(txtSted.getText(), LocalDate.parse(txtDato.getText()), LocalTime.parse(txtTid.getText()));
            updateList();
        }

    }

    public void opdaterAction() {
        if (txtSted.getText().isBlank() || txtDato.getText().isBlank() || txtTid.getText().isBlank()) {
            Alert emptyTextAlert = new Alert(Alert.AlertType.ERROR);
            emptyTextAlert.setContentText("One or more of the textfields are empty. You must provide both a place, a date and a time for the match.");
            emptyTextAlert.setTitle("Empty Textbox");
            emptyTextAlert.showAndWait();
        } else {
            String sted = txtSted.getText();
            LocalDate dato = LocalDate.parse(txtDato.getText());
            LocalTime tid = LocalTime.parse(txtTid.getText());

            Service.updateKamp(lwKampe.getSelectionModel().getSelectedItem(), sted, dato, tid);

        }

    }

    public void lavFilAction() {
        String path = "PRO1_22_6_9 proeve-proeve 5\\src\\Storage\\" + lwKampe.getSelectionModel().getSelectedItem().getSted() + ".txt";
        Service.createSpillerHonorarFile(lwKampe.getSelectionModel().getSelectedItem(),path);
    }
}
