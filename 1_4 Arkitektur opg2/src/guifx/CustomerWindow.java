package guifx;

import application.controller.Controller;
import application.model.Company;
import application.model.Customer;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomerWindow extends Stage {

    private TextField txfName;
    private ListView<Company> lswCompanies;

    public CustomerWindow(String title) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);


        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Name:");
        pane.add(lblName,0,0);

        txfName = new TextField();
        pane.add(txfName,1,0);

        Label lblCompanies = new Label("Companies");
        pane.add(lblCompanies,0,1);

        lswCompanies = new ListView<>();
        pane.add(lswCompanies,1,1, 1,2);
        lswCompanies.setPrefWidth(200);
        lswCompanies.setPrefHeight(200);
        lswCompanies.getItems().setAll(Controller.getCompanies());

        HBox btnBox = new HBox(40);
        pane.add(btnBox,0,3,2,1);
        btnBox.setPadding(new Insets(10, 0, 0, 0));
        btnBox.setAlignment(Pos.BASELINE_CENTER);

        Button btnOK = new Button("OK");
        btnBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> oKAction());

        Button btnCancel = new Button("Cancel");
        btnBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> cancelAction());

    }

    public void oKAction () {
        String name = txfName.getText().trim();
        Company companySelected = lswCompanies.getSelectionModel().getSelectedItem();
        if (!name.isBlank() && companySelected != null) {
            Customer customer = new Customer(name);
            Controller.addCustomerToCompany(customer, companySelected);
            this.hide();
        } else {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error!");
            error.setHeaderText("You must provide a name and a company");
            error.showAndWait();
        }
    }

    public void cancelAction () {
        this.hide();
    }
}
