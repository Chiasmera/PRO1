package Exercise6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application
{
    

    @Override
    public void start(Stage stage)
    {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent()
    {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(GraphicsContext gc)
    {


        // Arrow
        int lineStartX = 10;
        int lineStartY = 100;
        int lineLength = 150;

        gc.strokeLine(lineStartX+lineLength-10, lineStartY+4, lineStartX+lineLength, lineStartY);
        gc.strokeLine(lineStartX+lineLength, lineStartY, lineStartX+lineLength-10, lineStartY-4);


        //Horizontal line
        gc.strokeLine(lineStartX, lineStartY, lineStartX+lineLength, lineStartY);

        //line dividers
        int numberOfDividers = 11;
        int dividerSpace = (lineLength-10) / numberOfDividers;
        for (int i = 1; i <= numberOfDividers; i++) {
            int tickLength = 4;
            if (i % 5 == 0) {
                tickLength = tickLength * 2;
                gc.fillText(""+i, lineStartX+(dividerSpace*i)-4, lineStartY+tickLength+12);
            }
            gc.strokeLine(lineStartX+(dividerSpace*i), lineStartY-tickLength, lineStartX+(dividerSpace*i), lineStartY+tickLength);
        }




    }



}
