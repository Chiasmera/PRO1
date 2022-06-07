package Opgave4.example1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
        int startX = 150;
        int startY = 150;
        Color fillColor = Color.WHITE;
        Color strokeColor = Color.BLACK;

        Circle circle1 = new Circle(startX, startY, 100);
        pane.getChildren().add(circle1);
        circle1.setFill(Color.BLACK);
        circle1.setStroke(strokeColor);

        Circle circle2 = new Circle(startX, startY, 80);
        pane.getChildren().add(circle2);
        circle2.setFill(Color.WHITE);
        circle2.setStroke(strokeColor);

        Circle circle3 = new Circle(startX, startY, 60);
        pane.getChildren().add(circle3);
        circle3.setFill(Color.BLACK);
        circle3.setStroke(strokeColor);

        Circle circle4 = new Circle(startX, startY, 40);
        pane.getChildren().add(circle4);
        circle4.setFill(Color.WHITE);
        circle4.setStroke(strokeColor);

        Circle circle5 = new Circle(startX, startY, 20);
        pane.getChildren().add(circle5);
        circle5.setFill(Color.BLACK);
        circle5.setStroke(strokeColor);

    }
}
