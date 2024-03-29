package Opgave;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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
        int startX = 100;
        int startY = 100;
        Color fillColor = Color.BLUE;
        Color strokeColor = Color.BLUE;

        Rectangle firkant = new Rectangle(startX, startY,100, 50);
        pane.getChildren().add(firkant);
        firkant.setFill(fillColor);
        firkant.setStroke(strokeColor);

        Text navn   = new Text(startX+40, startY+70, "Julius");
        pane.getChildren().add(navn);
        navn.setFill(Color.RED);


    }
}
