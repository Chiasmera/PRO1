package GUI;

import Application.Controller.Service;
import Application.Model.Hold;
import Application.Model.Tilmelding;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {



    @Override
    public void start(Stage stage) {
        stage.setTitle("Fitness holdadministration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private ListView<Hold> lwHold = new ListView<>();
    private ListView<Tilmelding> lwTilmeldinger = new ListView<>();
    private Button btnOpretHold = new Button("Opret Hold");
    private Button btnOpdaterHold = new Button("Opdater Hold");
    private Button btnFindAdresse = new Button("Søg på adresse:");
    private TextField txtAdresse = new TextField();
    TextField txtAntalAdresse = new TextField();

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblHoldliste = new Label("Hold");
        pane.add(lblHoldliste, 0,0);

        pane.add(lwHold, 0,1,2,2);

        Label lblTilmeldinger = new Label("Tilmeldinger");
        pane.add(lblTilmeldinger, 2,0);

        pane.add(lwTilmeldinger, 2,1,2,2);

        pane.add(btnOpretHold, 0,3);
        btnOpretHold.setOnAction(actionEvent -> opretAction());

        pane.add(btnOpdaterHold,1,3);
        btnOpdaterHold.setOnAction(actionEvent -> opdaterAction());

        pane.add(btnFindAdresse,2,3);
        btnFindAdresse.setOnAction(actionEvent -> findAdressAction());


        txtAdresse.setEditable(true);
        pane.add(txtAdresse,3,3);


        txtAntalAdresse.setEditable(false);
        pane.add(txtAntalAdresse,4,3);

        ChangeListener<Hold> baneListener = (ov, oldHold, Newhold) -> this.updateSelected();
        lwHold.getSelectionModel().selectedItemProperty().addListener(baneListener);


        Service.createSomeObjects();
        lwHold.getItems().setAll(Service.getHold());
        lwHold.getSelectionModel().selectFirst();

        lwTilmeldinger.getItems().setAll(lwHold.getSelectionModel().getSelectedItem().getTilmeldinger());

    }

    public void updateSelected () {
        lwTilmeldinger.getItems().setAll(lwHold.getSelectionModel().getSelectedItem().getTilmeldinger());
    }

    public void findAdressAction() {
        String adresse = txtAdresse.getText().trim();
        Hold hold = lwHold.getSelectionModel().getSelectedItem();
        String antal = String.valueOf(hold.getAntalTilmeldinger(adresse));
        txtAntalAdresse.setText(antal);
    }

    public void opretAction () {

    }

    public void opdaterAction () {

    }
}
