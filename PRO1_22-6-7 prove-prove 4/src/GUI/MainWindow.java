package GUI;

import Application.Controller.Controller;
import Application.Model.Arrangement;
import Application.Model.Tutor;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.GridPane;

import javafx.stage.Stage;


public class MainWindow extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Tutoradministration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    ListView<Tutor> lwTutors = new ListView<>();
    ListView<Arrangement> lwArrangementer = new ListView<>();
    ListView<Arrangement> lwMulige = new ListView<>();
    TextField txtNavn = new TextField();
    TextField txtEmail = new TextField();
    Button btnFjern = new Button("Fjern");
    Button btnTilføj = new Button("Tilføj");

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        //Textfields
        pane.add(txtNavn, 3, 0, 2, 1);
        pane.add(txtEmail, 3, 1, 2, 1);

        //Listviews
        pane.add(lwTutors, 0, 1, 2, 5);
        lwTutors.prefHeight(200);
        lwTutors.autosize();

        pane.add(lwArrangementer, 3, 2, 2, 2);
        lwArrangementer.prefHeight(120);
        lwArrangementer.autosize();

        pane.add(lwMulige, 5, 2, 2, 2);
        lwMulige.prefHeight(120);
        lwMulige.autosize();

        //Labels
        Label lbltutor = new Label("Tutorer");
        pane.add(lbltutor, 0, 0);
        Label lblNavn = new Label("Navn");
        pane.add(lblNavn, 2, 0);
        Label lblEmail = new Label("Email");
        pane.add(lblEmail, 2, 1);
        Label lblArrangementer = new Label("Arrangementer");
        pane.add(lblArrangementer, 2, 2);
        Label lblMulige = new Label("Alle Mulige Arrangementer");
        pane.add(lblMulige, 5, 1);

        //Buttons
        pane.add(btnFjern, 3, 4);
        btnFjern.setOnAction(actionEvent -> fjernArrangement());


        pane.add(btnTilføj, 5, 4);
        btnTilføj.setOnAction(actionEvent -> tilføjArrangement());

        ChangeListener<Tutor> listener = (ov, oldTutor, newTutor) -> this.updateSelected();
        lwTutors.getSelectionModel().selectedItemProperty().addListener(listener);

        updateLists();
        lwTutors.getSelectionModel().selectFirst();
        lwMulige.getSelectionModel().selectFirst();

    }

    public void updateLists() {
        lwTutors.getItems().setAll(Controller.getTutorer());
        lwMulige.getItems().setAll(Controller.getArrangementer());

    }

    public void updateSelected() {
        if (lwTutors.getSelectionModel().getSelectedItem() != null) {
            txtNavn.setText(lwTutors.getSelectionModel().getSelectedItem().getNavn());
            txtEmail.setText(lwTutors.getSelectionModel().getSelectedItem().getEmail());

            lwArrangementer.getItems().setAll(lwTutors.getSelectionModel().getSelectedItem().getArrangementer());

        } else {
            txtNavn.clear();
            txtEmail.clear();
            lwArrangementer.getItems().clear();

        }
    }

    public void fjernArrangement() {
        Arrangement selected = lwArrangementer.getSelectionModel().getSelectedItem();
        Controller.removeArrangementFromTutor(selected, lwTutors.getSelectionModel().getSelectedItem());

        updateSelected();

    }

    public void tilføjArrangement() {
        try {
            Arrangement selected = lwMulige.getSelectionModel().getSelectedItem();
            Controller.addArrangementToTutor(selected, lwTutors.getSelectionModel().getSelectedItem());

        } catch (NullPointerException nullPointerException) {
            Alert nullAlert = new Alert(Alert.AlertType.ERROR);
            nullAlert.setContentText("Der er ikke valgt et arrangement. Intet arrangement er blevet tilføjet til tutoren");
            nullAlert.showAndWait();
        } catch (RuntimeException runtimeException) {
            Alert runAlert = new Alert(Alert.AlertType.ERROR);
            runAlert.setContentText(runtimeException.getMessage());
            runAlert.showAndWait();
        }

        updateSelected();

    }
}
