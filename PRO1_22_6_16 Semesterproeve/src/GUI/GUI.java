package GUI;

import Application.Controller.Controller;
import Application.Model.Medarbejder;
import Application.Model.Vagt;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Vagtplanlægning");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    //Elementer     ________________________________________________________________________________________
    private ListView<Medarbejder> lwMedarbejdere = new ListView<>();
    private ListView<Vagt> lwVagter = new ListView<>();
    private TextArea txaVagtInfo = new TextArea();
    private Button btnTildel = new Button("Tildel Vagt");
    private Button btnUdskriv = new Button("Udskriv vagt til fil");

    //Methods   -   Initial    ________________________________________________________________________________________
    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblMedarbejdere = new Label("Alle Medarbejdere");
        pane.add(lblMedarbejdere, 0, 0);

        pane.add(lwMedarbejdere, 0, 1, 2, 1);

        Label lblVagter = new Label("Alle Vagter");
        pane.add(lblVagter, 2, 0);

        pane.add(lwVagter, 2, 1, 2, 1);

        Label lblInfoVagt = new Label("Valgt vagt");
        pane.add(lblInfoVagt, 4, 0);

        pane.add(txaVagtInfo, 4, 1, 2, 1);

        pane.add(btnTildel, 2, 2);
        btnTildel.setOnAction(actionEvent -> tildelAction());

        pane.add(btnUdskriv, 4, 2);
        btnUdskriv.setOnAction(actionEvent -> udskrivaction());

        ChangeListener<Vagt> vagtListener = (ov, oldVagt, newVagt) -> this.updateSelected();
        lwVagter.getSelectionModel().selectedItemProperty().addListener(vagtListener);

        Controller.initStorage();
        lwMedarbejdere.getItems().setAll(Controller.getMedarbejdere());
        lwMedarbejdere.getSelectionModel().selectFirst();
        lwVagter.getItems().setAll(Controller.getVagter());
        lwVagter.getSelectionModel().selectFirst();
        updateSelected();
    }

    //Methods   -   Buttons     ________________________________________________________________________________________
    /**
     * Tilføjer den valgte medarbejder til den valgte vagt. Viser en Alert hvis medarbejderen allerede har en vagt i tidsrummet
     */
    public void tildelAction() {
        Vagt vagt = lwVagter.getSelectionModel().getSelectedItem();
        Medarbejder medarbejder = lwMedarbejdere.getSelectionModel().getSelectedItem();
        try {
            //Controller.addMedarbejderToVagt(medarbejder, vagt);
            medarbejder.addVagt(vagt);
        } catch (RuntimeException runtimeException) {
            Alert busyAlert = new Alert(Alert.AlertType.ERROR);
            busyAlert.setTitle("Tildel Vagt");
            busyAlert.setHeaderText("Vagt kan ikke tildeles");
            busyAlert.setContentText(runtimeException.getMessage());
            busyAlert.showAndWait();
        }

        updateSelected();

    }

    /**
     * Udskriver den valgte vagt til en fil i programmets folder
     */
    public void udskrivaction() {
        Vagt vagt = lwVagter.getSelectionModel().getSelectedItem();
        try {
            String fileName = vagt.getNavn() + ".txt";
            Controller.udskrivVagtplan(vagt, fileName);
        } catch (RuntimeException runtimeException) {
            Alert pathAlert = new Alert(Alert.AlertType.ERROR);
            pathAlert.setTitle("Printing failed!");
            pathAlert.setContentText(runtimeException.getMessage());
            pathAlert.showAndWait();
        }

    }

    //Methods   -   Other    ________________________________________________________________________________________
    /**
     * Opdaterer infovinduet med information om den valgte vagt.
     */
    public void updateSelected() {
        Vagt vagt = lwVagter.getSelectionModel().getSelectedItem();
        String text =
                "Navn:\t" + vagt.getNavn() + "\n"
                        + "Fra\t\t: " + vagt.getTidFra() + "\n"
                        + "Til\t\t: " + vagt.getTidtil() + "\n"
                        + "Status\t: " + vagt.status() + "\n\n"
                        + "Tilknyttede medarbejdere:\n";
        for (Medarbejder m : vagt.getMedarbejdere()) {
            text = text + m.getNavn()+ " ";
        }
        txaVagtInfo.setText(text);
    }

}
