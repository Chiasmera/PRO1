package Opgave2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {
    TextField felt1;
    TextField felt2;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Swap Frame");

        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        pane.setGridLinesVisible(true);

        felt1 = new TextField();
        pane.add(felt1, 0,0);

        felt2 = new TextField();
        pane.add(felt2, 0,1);

        Button knap = new Button("Ombyt");
        pane.add(knap, 0,2);

        knap.setOnAction(event -> bytOmAction());

    }

    public void bytOmAction () {
        String nytFelt1 = felt2.getText();
        String nytFelt2 = felt1.getText();

        felt1.setText(nytFelt1);
        felt2.setText(nytFelt2);
    }
}
