package GUI;

import Application.Controller.Service;
import Application.Model.Bane;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OpretBaneWindow extends Stage {


    public OpretBaneWindow(Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setTitle("Add Person");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    TextField txtNummer = new TextField();
    TextField txtInfo = new TextField();
    Button btnOk = new Button("OK");
    Button btnCancel = new Button("Cancel");

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblNummer = new Label("Nummer:");
        pane.add(lblNummer, 0, 0);
        Label lblInfo = new Label("Info:");
        pane.add(lblInfo, 0, 1);

        pane.add(txtNummer, 1, 0, 2, 1);
        pane.add(txtInfo, 1, 1, 2, 1);

        pane.add(btnOk, 1, 2);
        btnOk.setOnAction(actionEvent -> okAction());

        pane.add(btnCancel, 2, 2);
        btnCancel.setOnAction(actionEvent -> cancelAction());

    }

    public void cancelAction() {
        this.hide();
    }

    public void okAction() {
        if (txtNummer.getText().isBlank()) {
            Alert numAlert = new Alert(Alert.AlertType.ERROR);
            numAlert.setTitle("Missing number");
            numAlert.setContentText("You must input a number!");
            numAlert.showAndWait();
        } else {
            try {
                Service.createBane(Integer.parseInt(txtNummer.getText()), txtInfo.getText());
                this.hide();
            } catch (NumberFormatException numberFormatException) {
                Alert numAlert = new Alert(Alert.AlertType.ERROR);
                numAlert.setTitle("Not a number");
                numAlert.setContentText("The input is not a number. You must input a number!");
                numAlert.showAndWait();
            }
        }
    }


}
