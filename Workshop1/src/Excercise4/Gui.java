package Excercise4;

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

        //Del 1
//        int i = 1;
//        while (i <= 5) {
//            int startX = 60;
//            int startY = 60;
//
//            int length = 20*i;
//            int height = 20*i;
//            int x = startX-length/2;
//            int y = startY - height/2;
//
//            gc.strokeOval(x, y, length, height);
//            i++;
//
//        }

        //del 2
//        int i = 1;
//        while (i <= 5) {
//            int centerX = 20;
//            int centerY = 60;
//
//            int length = 20*i;
//            int height = 20*i;
//            int x = centerX;
//            int y = centerY - i*10;
//
//            gc.strokeOval(x, y, length, height);
//            i++;
//
//        }

        int antalElipser = 13;
        int i = 1;
        while (i <= antalElipser) {
            int centerX = 10 + 10*antalElipser;
            int centerY = 80;

            int length = 20*i;
            int height = 50;

            int x = centerX - 10*i;
            int y = centerY;

            gc.strokeOval(x, y, length, height);
            i++;

        }



    }



}
