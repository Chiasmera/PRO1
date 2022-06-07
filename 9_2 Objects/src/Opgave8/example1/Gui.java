package Opgave8.example1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);
        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
        Rectangle verticalPole = new Rectangle(175, 5, 50, 400);
        pane.getChildren().add(verticalPole);
        verticalPole.setFill(Color.SADDLEBROWN);
        verticalPole.setStroke((Color.BLACK));

        Rectangle crossPole = new Rectangle(25, 5, 350, 50);
        pane.getChildren().add(crossPole);
        crossPole.setFill(Color.SADDLEBROWN);
        crossPole.setStroke((Color.BLACK));



        Polygon body = new Polygon();
        body.getPoints().addAll(new Double[]{
                50.0, 30.0,
                350.0, 30.0,
                350.0, 230.0,
                200.0, 330.0,
                50.0, 230.0,
        } );
        pane.getChildren().add(body);
        body.setFill(Color.RED);
        body.setStroke((Color.BLACK));

        Polygon cross = new Polygon();
        cross.getPoints().addAll(new Double[]{
                175.0, 30.0,
                225.0, 30.0,
                225.0, 180.0,
                350.0, 180.0,
                350.0, 230.0,
                225.0, 230.0,

                225.0,312.5,
                200.0, 330.0,
                175.0, 312.5,

                175.0, 230.0,
                50.0, 230.0,
                50.0, 180.0,
                175.0, 180.0,
        } );
        pane.getChildren().add(cross);
        cross.setFill(Color.WHITE);
        cross.setStroke((Color.BLACK));

    }
}
