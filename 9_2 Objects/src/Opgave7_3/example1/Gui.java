package Opgave7_3.example1;

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
        Color fillColor = Color.YELLOW;
        Color strokeColor = Color.BLACK;

        Circle sol = new Circle(300, 100, 30);
        pane.getChildren().add(sol);
        sol.setFill(fillColor);
        sol.setStroke(strokeColor);

        Rectangle hus = new Rectangle(10, 180, 120,120);
        pane.getChildren().add(hus);
        hus.setFill(Color.RED);
        hus.setStroke(Color.RED);

        Line jord = new Line(0,300,400,300);
        pane.getChildren().add(jord);
        jord.setStroke(strokeColor);

        Rectangle vindue = new Rectangle(30, 200, 40,40);
        pane.getChildren().add(vindue);
        vindue.setFill(Color.BLACK);
        vindue.setStroke(Color.BLACK);

        Polygon tag = new Polygon();
        tag.getPoints().addAll(new Double[]{
                0.0, 180.0,
                140.0, 180.0,
                75.0, 60.0,

        });
        pane.getChildren().add(tag);
        tag.setFill(Color.GREEN);
        vindue.setStroke((Color.GREEN));

    }
}
