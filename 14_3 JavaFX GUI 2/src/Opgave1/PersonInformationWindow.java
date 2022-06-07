package Opgave1;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonInformationWindow extends Stage {

    public PersonInformationWindow (Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle("Add Person");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    //Fields
    Person personToAdd;

    Label lblName = new Label("Name:");
    TextField txtName = new TextField();
    Label lblTitle = new Label("Title:");
    TextField txtTitle = new TextField();

    CheckBox chbxSenior = new CheckBox();
    Label lblSenior = new Label("Senior");

    Button okButton = new Button("OK");
    Button cancelButton = new Button("Cancel");

    public void initContent (GridPane pane) {

        pane.setPadding(new Insets(20));
        pane.setVgap(10);
        pane.setHgap(10);

        pane.add(lblName,0,0);
        pane.add(txtName,1,0,2,1);

        pane.add(lblTitle,0,1);
        pane.add(txtTitle,1,1,2,1);

        pane.add(chbxSenior,1,2);
        pane.add(lblSenior,2,2);

        pane.add(okButton, 1,3);
        okButton.setOnAction(event -> okayAction());

        pane.add(cancelButton, 2,3);
        cancelButton.setOnAction(event -> cancelAction());
    }

    public void okayAction () {
        if (txtName.getText().isBlank() || txtTitle.getText().isBlank()) {
            Alert missingInput = new Alert(Alert.AlertType.ERROR);
            missingInput.setTitle("Missing Information!");
            missingInput.setHeaderText("You must provide both a Name and a Title!");
            missingInput.showAndWait();
        } else {
            personToAdd = new Person(
                    txtName.getText().trim(),
                    txtTitle.getText().trim(),
                    chbxSenior.isSelected());
            }
        txtName.clear();
        txtTitle.clear();
        chbxSenior.setSelected(false);
        this.hide();

    }

    public void cancelAction () {
        txtName.clear();
        txtTitle.clear();
        chbxSenior.setSelected(false);
        personToAdd = null;
        this.hide();
    }

    public Person getPersonToAdd() {
        return personToAdd;
    }
}
