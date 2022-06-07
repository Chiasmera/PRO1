package example1;

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
        int startX = 50;
        Color fillColor = Color.YELLOW;
        Color strokeColor = Color.BLACK;

        Circle circle = new Circle(startX, 70, 30);
        pane.getChildren().add(circle);
        circle.setFill(fillColor);
        circle.setStroke(strokeColor);

        Rectangle rektangel = new Rectangle(startX+100, 70, 60,60);
        pane.getChildren().add(rektangel);
        rektangel.setFill(fillColor);
        rektangel.setStroke(strokeColor);

        Line linje = new Line(startX+200,70,startX+200,140);
        pane.getChildren().add(linje);
        linje.setStroke(strokeColor);
    }
}
