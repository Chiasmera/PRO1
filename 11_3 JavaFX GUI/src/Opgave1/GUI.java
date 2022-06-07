package Opgave1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class GUI extends Application {

    TextField firstName;
    TextField secondName;
    TextField combinedName;

    public void start (Stage stage) {
        stage.setTitle("Kombiner navne");

        //Laver et nyt gridpane
        GridPane pane = new GridPane();

        //Kalder en metode på panen, som gør alt det der skal i panen
        this.initContent(pane);


        //laver en ny scene, som indeholder gridpanen
        Scene scene = new Scene(pane);

        //Fortæller at det er den her specifikke scene vi vil se lige nu
        stage.setScene(scene);

        //Gør stagen synlig
        stage.show();


    }

    /**
     * Metoden som gører alt i denne gridpane
     * @param pane den gridpane som metoden skal køre sine ting p
     */
    public void initContent (GridPane pane) {

        //Sætter gridlines som synlige, så man kan se hvad man laver
        pane.setGridLinesVisible(false);

        //Sætter padding
        pane.setPadding(new Insets(20));

        //Sætter gaps mellem elementer
        pane.setHgap(10);
        pane.setVgap(10);

        //Laver et nyt textfield som er 2 langt, ved 1,1
        firstName = new TextField();
        pane.add(firstName, 0, 0);

        //Laver et nyt textfield som er 2 langt, ved 3,1
        secondName = new TextField();
        pane.add(secondName, 2, 0);

        //Laver et nyt textfield som er 5 langt, ved 1,3
        combinedName = new TextField();
        pane.add(combinedName, 0, 1, 3, 1);

        //Laver en button
        Button knap = new Button("Kombiner");
        pane.add(knap, 1, 2);

        //Kører en metode når knappen bliver trykket på
        knap.setOnAction(event -> connectNamesAction());

    }

    public void connectNamesAction () {
        String name = firstName.getText()+" "+ secondName.getText();
        combinedName.setText(name);
    }
}
