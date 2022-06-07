package Opgave5.example1;

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
        Color fillColor = Color.TRANSPARENT;
        Color strokeColor = Color.BLACK;

        Circle circle = new Circle(startX, startY, 100);
        pane.getChildren().add(circle);
        circle.setFill(fillColor);
        circle.setStroke(Color.BLUE);
        circle.setStrokeWidth(10);

        Circle circle2 = new Circle(startX+100, startY+100, 100);
        pane.getChildren().add(circle2);
        circle2.setFill(fillColor);
        circle2.setStroke(Color.YELLOW);
        circle2.setStrokeWidth(10);

        Circle circle3 = new Circle(startX+200, startY, 100);
        pane.getChildren().add(circle3);
        circle3.setFill(fillColor);
        circle3.setStroke(Color.BLACK);
        circle3.setStrokeWidth(10);

        Circle circle4 = new Circle(startX+300, startY+100, 100);
        pane.getChildren().add(circle4);
        circle4.setFill(fillColor);
        circle4.setStroke(Color.GREEN);
        circle4.setStrokeWidth(10);

        Circle circle5 = new Circle(startX+400, startY, 100);
        pane.getChildren().add(circle5);
        circle5.setFill(fillColor);
        circle5.setStroke(Color.RED);
        circle5.setStrokeWidth(10);
    }
}
