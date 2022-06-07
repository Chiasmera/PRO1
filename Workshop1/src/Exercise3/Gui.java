package Exercise3;

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

        int i = 1;
        while (i <= 5) {
            int x1 = 20 * i;
            int y1 = 10;
            int x2 = 20 * i;
            int y2 = 100;

            gc.strokeLine(x1, y1, x2, y2);
            i++;

        }

        i = 1;
        while (i <= 5) {
            int x1 = 120 + 10 ;
            int y1 = 20* i;
            int x2 = 120 + 100;
            int y2 = 20* i;

            gc.strokeLine(x1, y1, x2, y2);
            i++;

        }

        i = 1;
        while (i <= 5) {
            int x1 = 100 - 20*i ;
            int y1 = 100 + 20* i;
            int x2 = 50 + i*20;
            int y2 = 100 + 20 * i;

            gc.strokeLine(x1, y1, x2, y2);
            i++;

        }




    }



}
