package Opgave3.example1;

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
        int startX = 70;
        int startY = 70;
        Color fillColor = Color.YELLOW;
        Color strokeColor = Color.BLACK;

        Circle head = new Circle(startX+90, startY+80, 100);
        pane.getChildren().add(head);
        head.setFill(Color.WHITE);
        head.setStroke(strokeColor);

        Circle leftEye = new Circle(startX+60, startY+60, 25);
        pane.getChildren().add(leftEye);
        leftEye.setFill(Color.WHITE);
        leftEye.setStroke(strokeColor);

        Circle rightEye = new Circle(startX+120, startY+60, 25);
        pane.getChildren().add(rightEye);
        rightEye.setFill(Color.WHITE);
        rightEye.setStroke(strokeColor);

        Line linje = new Line(startX+60,startY+120,startX+120,startY+120);
        pane.getChildren().add(linje);
        linje.setStroke(strokeColor);
    }
}
