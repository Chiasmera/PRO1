package TestTing;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Test extends Application {

    @Override
    public void start(Stage stage) {
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
     * Tilføjer elementer til panen, og udfører funktionaliteten i den
     * @param pane En pane fra den aktuelle scene
     */
    public void initContent (GridPane pane) {

    }


}
