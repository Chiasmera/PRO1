package Exercise1;

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
        int scaleX = 2;
        int scaleY = 2;

        // Arrow 1
        int x1 = 100;
        int y1 = 75;

        gc.strokeLine(x1, y1, x1+(10*scaleX), y1-(4*scaleY));
        gc.strokeLine(x1+(10*scaleX), y1-(4*scaleY), x1, y1-(8*scaleY));

        // Arrow 2
        x1 = 100 ;
        y1 = 125 ;

        gc.strokeLine(x1, y1, x1+(10*scaleX), y1-(4*scaleY));
        gc.strokeLine(x1+(10*scaleX), y1-(4*scaleY), x1, y1-(8*scaleY));

        // Arrow 3
        x1 = 20 ;
        y1 = 50 ;

        gc.strokeLine(x1, y1, x1+(10*scaleX), y1-(4*scaleY));
        gc.strokeLine(x1+(10*scaleX), y1-(4*scaleY), x1, y1-(8*scaleY));


    }



}
