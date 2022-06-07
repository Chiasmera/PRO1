package Opgave3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

    TextField textToSplit;
    TextField firstPart;
    TextField secondPart;

    @Override
    public void start (Stage stage) {
        stage.setTitle("Split Text");

        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void initContent (GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setVgap(10);
        pane.setHgap(10);

        pane.setGridLinesVisible(false);

        textToSplit = new TextField();
        pane.add(textToSplit, 0,0, 3, 1);

        firstPart= new TextField();
        pane.add(firstPart, 0,1);

        secondPart = new TextField();
        pane.add(secondPart, 2,1);

        Button knap = new Button("Split");
        pane.add(knap, 1, 2);

        knap.setOnAction(event -> splitTextAction());
    }

    public void splitTextAction() {
        int spacePoint = textToSplit.getText().indexOf(" ");
        firstPart.setText(textToSplit.getText(0, spacePoint));
        secondPart.setText(textToSplit.getText(spacePoint+1,textToSplit.getText().length()));
    }
}
