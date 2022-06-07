package gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class YatzyGameEndWindow extends Stage {

    int totalPoints = 50;

    public YatzyGameEndWindow (Stage owner, int point) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(300);
        this.setMinWidth(300);
        this.setResizable(false);

        totalPoints = point;

        this.setTitle("Game Finished");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);


    }

    public void initContent (GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setStyle("-fx-border-color: black");

        Label gameOver = new Label("The game is over!\nYour total point score is:");
        pane.add(gameOver,0,0,3,1);
        GridPane.setHalignment(gameOver, HPos.CENTER);

        Label points = new Label(""+totalPoints);
        pane.add(points, 1,2);
        GridPane.setHalignment(points, HPos.CENTER);
        points.setFont(Font.font("Arial", 32));

        Button playAgain = new Button("Play again?");
        pane.add(playAgain, 0,4);
        playAgain.setPrefWidth(100);
        playAgain.setOnAction(event -> playAgainAction());

        Button exit = new Button("Exit");
        pane.add(exit,2,4);
        exit.setPrefWidth(100);
        exit.setOnAction(event -> exitAction());

        //Empty panes for space reasons
        Pane emptyPane = new Pane();
        pane.add(emptyPane, 1, 1);
        emptyPane.setMinSize(15, 15);

        Pane emptyPane2 = new Pane();
        pane.add(emptyPane2, 1, 3);
        emptyPane2.setMinSize(15, 15);


    }

    public void playAgainAction() {
        this.hide();
    }

    public void exitAction() {
        System.exit(0);
    }
}
