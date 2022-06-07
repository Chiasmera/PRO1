package Opgave5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {
    TextField celcius;
    TextField fahrenheit;


    public void start (Stage stage) {
        stage.setTitle("Coversion");

        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();;
    }

    public void initContent (GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setVgap(10);
        pane.setHgap(10);

        Label celciusLabel = new Label("Celsius");
        pane.add(celciusLabel,3,0);
        Label fahrenheitLabel = new Label("Fahrenheit");
        pane.add(fahrenheitLabel,1,0);


        fahrenheit = new TextField();
        pane.add(fahrenheit, 1,1);

        celcius = new TextField();
        pane.add(celcius, 3,1);

        Button fahrenheitButton = new Button("Convert");
        pane.add(fahrenheitButton, 1,2);
        fahrenheitButton.setOnAction(event -> convertFahrenheitAction());

        Button celciusButton = new Button("Convert");
        pane.add(celciusButton, 3,2);
        celciusButton.setOnAction(event -> convertCelciusAction());
    }

    public void convertFahrenheitAction () {

        if (!fahrenheit.getText().isBlank()) {
            int celciusResult = (Integer.parseInt(fahrenheit.getText()) * 5 - 160) / 9;
            celcius.setText("" + celciusResult);
        }
    }

    public void convertCelciusAction() {
        if (!celcius.getText().isBlank()) {
            int fahrenheitResult = Integer.parseInt(celcius.getText()) * 9/5 + 32;
            fahrenheit.setText(""+fahrenheitResult);
        }
    }

}
