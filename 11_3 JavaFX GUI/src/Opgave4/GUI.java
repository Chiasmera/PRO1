package Opgave4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

    //Fields
    Button plus;
    Button minus;
    TextField text;
    Label titel;
    int textNumber = 50;


    @Override
    public void start (Stage stage) {
        stage.setTitle("Tæl op");

        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void initContent (GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(2);

        plus = new Button("+");
        pane.add(plus, 3,1);

        minus = new Button("-");
        pane.add(minus, 1, 1);

        text = new TextField(""+textNumber);
        pane.add(text,2,1);
        text.setPrefWidth(35);


        titel = new Label("NUMBER:");
        pane.add(titel, 2,0);

        plus.setOnAction(event -> increaseAction());
        minus.setOnAction(event -> reduceAction());
        text.setOnAction(event -> setNumberAction());
    }

    public void increaseAction() {
        textNumber++;
        text.setText(""+textNumber);
    }

    public void reduceAction () {
        textNumber--;
        text.setText(""+textNumber);
    }

    public void setNumberAction () {
        textNumber = Integer.valueOf(text.getText());
    }
}
