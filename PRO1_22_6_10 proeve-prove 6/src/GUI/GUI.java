package GUI;

import Application.Controller.Service;
import Application.Model.Bane;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class GUI extends Application {

    Stage stage;

    @Override
    public void start(Stage stage) {

        stage.setTitle("Tennisbane Administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        this.stage = stage;

    }

    ListView<Bane> lwBaner = new ListView<>();
    ListView<LocalTime> lwLedigeTider = new ListView<>();
    TextField txtDato = new TextField();
    Button btnOpret = new Button("Opret Bane");

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 0, 0);

        pane.add(txtDato, 0, 1, 2, 1);

        Label lblBaner = new Label("Baner:");
        pane.add(lblBaner, 0, 2);

        pane.add(lwBaner, 0, 3, 2, 2);


        Label lblLedigeTider = new Label("Ledige Tider:");
        pane.add(lblLedigeTider, 2, 0);

        pane.add(lwLedigeTider, 2, 1, 2, 4);

        ChangeListener<Bane> baneListener = (ov, oldBane, newBane) -> this.updateSelected();
        lwBaner.getSelectionModel().selectedItemProperty().addListener(baneListener);


        pane.add(btnOpret, 0, 5);
        btnOpret.setOnAction(actionEvent -> opretBaneAction());


        Service.initStorage();
        lwBaner.getItems().setAll(Service.getBaner());
        lwBaner.getSelectionModel().selectFirst();
        txtDato.setText(LocalDate.now().toString());

    }

    public void updateSelected() {
        try {
            LocalDate dato = LocalDate.parse(txtDato.getText());
            Bane selectedBane = lwBaner.getSelectionModel().getSelectedItem();
            lwLedigeTider.getItems().setAll(selectedBane.getLedigeTiderPaaDag(dato));

        } catch (DateTimeParseException dateException) {
            Alert dateAlert = new Alert(Alert.AlertType.ERROR);
            dateAlert.setTitle("Invalid Date");
            dateAlert.setContentText("Cannot interpret the input as a date. Make sure you have used the format \"Year-Month-day\"");
        }
    }

    public void opretBaneAction() {
        OpretBaneWindow nyBaneVindue = new OpretBaneWindow(stage);
        nyBaneVindue.showAndWait();
        lwBaner.getItems().setAll(Service.getBaner());
    }
}
