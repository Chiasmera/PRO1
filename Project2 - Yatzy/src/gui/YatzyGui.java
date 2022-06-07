package gui;

import com.sun.source.tree.NewClassTree;
import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Yatzy;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class YatzyGui extends Application {
    Stage stage;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        this.stage = stage;
    }

    // -------------------------------------------------------------------------

    // Shows the face values of the 5 dice.
    private TextField[] txfValues;
    // Shows the results previously selected .
    // For free results (results not set yet), the results
    // corresponding to the actual face values of the 5 dice are shown.
    private TextField[] txfResults;
    // Shows points in sums, bonus and total.
    private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
    //Shows what dice are being held
    boolean[] heldDice = new boolean[5];

    private Button btnRoll;

    int filledFields = 0;
    int total = 0;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        //Initialises txfvalues
        txfValues = new TextField[5];
        for (int i = 0; i < 5; i++) {
            txfValues[i] = new TextField();
            txfValues[i].setPrefSize(100, 100);
            txfValues[i].setEditable(false);
            txfValues[i].setFont(Font.font(45));
            txfValues[i].setAlignment(Pos.CENTER);
            txfValues[i].setUserData(i);
            txfValues[i].setStyle("-fx-background-color: white;" + "-fx-border-color: black;");
            dicePane.add(txfValues[i], i, 0);

            txfValues[i].setOnMouseClicked(event -> this.holdAction(event));
        }

        //Initializes the roll button
        btnRoll = new Button("First Roll");
        btnRoll.setPrefSize(100, 60);
        dicePane.add(btnRoll, 2, 2);

        btnRoll.setOnAction(event -> rollDiceAction());


        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int w = 50; // width of the text fields

        //Initializes labels for scores in left column
        Label ones = new Label("1's");
        scorePane.add(ones, 0, 0);
        Label twos = new Label("2's");
        scorePane.add(twos, 0, 1);
        Label threes = new Label("3's");
        scorePane.add(threes, 0, 2);
        Label fours = new Label("4's");
        scorePane.add(fours, 0, 3);
        Label fives = new Label("5's");
        scorePane.add(fives, 0, 4);
        Label sixes = new Label("6's");
        scorePane.add(sixes, 0, 5);

        //Initializes labels for scores in the right column
        int columnNumRight = 7;
        Label onePair = new Label("One Pair");
        scorePane.add(onePair, columnNumRight, 0);
        Label twoPairs = new Label("Two Pairs");
        scorePane.add(twoPairs, columnNumRight, 1);
        Label threeSame = new Label("Three of a kind");
        scorePane.add(threeSame, columnNumRight, 2);
        Label fourSame = new Label("Four of a kind");
        scorePane.add(fourSame, columnNumRight, 3);
        Label fullHouse = new Label("Full House");
        scorePane.add(fullHouse, columnNumRight, 4);
        Label smallStraight = new Label("Small Straight");
        scorePane.add(smallStraight, columnNumRight, 5);
        Label largeStraight = new Label("Large Straight");
        scorePane.add(largeStraight, columnNumRight, 6);
        Label chance = new Label("Chance");
        scorePane.add(chance, columnNumRight, 7);
        Label yatzy = new Label("Yatzy");
        scorePane.add(yatzy, columnNumRight, 8);

        //Initializes textfields for scores
        txfResults = new TextField[15];
        for (int i = 0; i < txfResults.length; i++) {
            txfResults[i] = new TextField();
            txfResults[i].setPrefWidth(40);
            txfResults[i].setEditable(false);
            txfResults[i].setAlignment(Pos.CENTER);
            txfResults[i].setUserData(true);
            txfResults[i].setOnMouseClicked(event -> this.setScoreAction(event));
            txfResults[i].setStyle("-fx-background-color: white;" + "-fx-text-fill: black;");
            if (i < 6) {
                scorePane.add(txfResults[i], 1, i);
            } else {
                scorePane.add(txfResults[i], columnNumRight + 1, i - 6);
            }
        }


        //Initializes labels and textfields for the sums, the bonus and the total
        Label firstSum = new Label("Sum");
        scorePane.add(firstSum, 0, 10);
        txfSumSame = new TextField();
        scorePane.add(txfSumSame, 1, 10);
        txfSumSame.setPrefWidth(40);
        txfSumSame.setEditable(false);
        txfSumSame.setAlignment(Pos.CENTER);

        Label bonus = new Label("Bonus");
        scorePane.add(bonus, 2, 10);
        txfBonus = new TextField();
        scorePane.add(txfBonus, 3, 10);
        txfBonus.setPrefWidth(40);
        txfBonus.setEditable(false);
        txfBonus.setAlignment(Pos.CENTER);

        Label secondSum = new Label("Sum");
        scorePane.add(secondSum, columnNumRight, 10);
        txfSumOther = new TextField();
        scorePane.add(txfSumOther, columnNumRight + 1, 10);
        txfSumOther.setPrefWidth(40);
        txfSumOther.setEditable(false);
        txfSumOther.setAlignment(Pos.CENTER);

        Label total = new Label("Total");
        scorePane.add(total, 10, 10);
        txfTotal = new TextField();
        scorePane.add(txfTotal, 11, 10);
        txfTotal.setPrefWidth(40);
        txfTotal.setEditable(false);
        txfTotal.setAlignment(Pos.CENTER);

        //Empty panes to make some space, for layout purposes
        Pane emptyPane = new Pane();
        scorePane.add(emptyPane, 4, 9);
        emptyPane.setMinSize(15, 15);

        Pane emptyPane2 = new Pane();
        scorePane.add(emptyPane2, 9, 10);
        emptyPane2.setPrefWidth(30);

    }

    // -------------------------------------------------------------------------

    private Yatzy dice = new Yatzy();

    /**
     * Toggles dice between states. Toggled dice are held and will not be rolled by the roll button
     *
     * @param event click on a dice textfield
     */
    public void holdAction(Event event) {
        TextField txt = (TextField) event.getSource();
        if (dice.getThrowCount() > 0) {
            if (!heldDice[(int) txt.getUserData()]) {
                heldDice[(int) txt.getUserData()] = true;
                txt.setStyle("-fx-background-color: light-grey;" + "-fx-border-color: black;");
            } else {
                heldDice[(int) txt.getUserData()] = false;
                txt.setStyle("-fx-background-color: white;" + "-fx-border-color: black;");
            }
        }
    }

    /**
     * Rolls dice, and updates the roll button and the score fields
     */
    public void rollDiceAction() {
        //Generates dicethrow
        dice.throwDice(heldDice);

        //assigns dice values to each of the dice textfields
        int[] tempValues = dice.getValues();
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i].setText(String.valueOf(tempValues[i]));
        }

        //updates the roll button
        updateRollButton();

        //updates the score fields
        updateScores();
    }


    /**
     * Updates text on button to reflect current throw number. Disables button if max throws is reached
     */
    private void updateRollButton() {
        if (dice.getThrowCount() == 0) {
            btnRoll.setText("First Roll");
            btnRoll.setDisable(false);
        } else if (dice.getThrowCount() == 1) {
            btnRoll.setText("Second Roll");
            btnRoll.setDisable(false);
        } else if (dice.getThrowCount() == 2) {
            btnRoll.setText("Last Roll!");
            btnRoll.setDisable(false);
        } else {
            btnRoll.setText("No rolls left!");
            btnRoll.setDisable(true);
        }

    }

    /**
     * calculates potential scores based on the current roll, and set the text of every non-locked scorefield
     */
    private void updateScores() {
        dice.calcCounts();

        int[] potentialScores = new int[15];
        potentialScores[0] = dice.sameValuePoints(1);
        potentialScores[1] = dice.sameValuePoints(2);
        potentialScores[2] = dice.sameValuePoints(3);
        potentialScores[3] = dice.sameValuePoints(4);
        potentialScores[4] = dice.sameValuePoints(5);
        potentialScores[5] = dice.sameValuePoints(6);
        potentialScores[6] = dice.onePairPoints();
        potentialScores[7] = dice.twoPairPoints();
        potentialScores[8] = dice.threeSamePoints();
        potentialScores[9] = dice.fourSamePoints();
        potentialScores[10] = dice.fullHousePoints();
        potentialScores[11] = dice.smallStraightPoints();
        potentialScores[12] = dice.largeStraightPoints();
        potentialScores[13] = dice.chancePoints();
        potentialScores[14] = dice.yatzyPoints();

        for (int i = 0; i < txfResults.length; i++) {
            if ((boolean) txfResults[i].getUserData()) {
                txfResults[i].setText("" + potentialScores[i]);
            }
        }
    }

    /**
     * Updates the sum, bonus and total textfields
     */
    private void updateSums() {
        int sumSame = 0;
        int sumOther = 0;
        for (int i = 0; i < txfResults.length; i++) {
            if (i < 6) {
                sumSame += Integer.parseInt(txfResults[i].getText());
            } else {
                sumOther += Integer.parseInt(txfResults[i].getText());
            }
        }
        txfSumSame.setText("" + sumSame);
        txfSumOther.setText("" + sumOther);

        int bonus = 0;
        if (sumSame >= 63) {
            txfBonus.setText("" + 50);
        } else {
            txfBonus.setText("" + 0);
        }

        setTotal(sumSame + sumOther + bonus);
        txfTotal.setText("" + total);
    }
    // -------------------------------------------------------------------------

    /**
     * Marks down the points in the field, then starts a new turn
     *
     * @param event player clicking a score field
     */
    private void setScoreAction(Event event) {
        TextField txt = (TextField) event.getSource();
        if ((boolean) txt.getUserData() && dice.getThrowCount() > 0) {
            //Sets the color and marks the field as unchangeable
            txt.setUserData(false);
            txt.setStyle("-fx-background-color: light-grey;" + "-fx-text-fill: blue;");

            //Resets dice and number of throws
            resetDice();

            //fills scorefields & updates the roll button
            updateScores();
            updateRollButton();

            //Updates sums and total
            updateSums();

            //adds one to the filledFields
            filledFields++;

            //Checks for game end
            checkGameend();
        }
    }

    /**
     * resets the dice to their original state
     */
    private void resetDice() {
        //resets number of throws
        dice.resetThrowCount();

        //clears dice values and resets holding
        int[] tempValues = {0, 0, 0, 0, 0};
        dice.setValues(tempValues);
        for (TextField t : txfValues) {
            t.clear();
            heldDice[(int) t.getUserData()] = false;
            t.setStyle("-fx-background-color: white;" + "-fx-border-color: black;");
        }


    }

    /**
     * checks if all fields are filled, if so, ends the game
     */
    private void checkGameend() {
        if (filledFields >= txfResults.length) {
            gameEnd();
        }

    }

    /**
     * shows the game end window and resets the game if the players wants to play again
     */
    private void gameEnd() {
        YatzyGameEndWindow endWindow = new YatzyGameEndWindow(stage, getTotal());
        endWindow.showAndWait();

        resetDice();
        filledFields = 0;

        for (TextField t : txfResults) {
            t.setUserData(true);
            t.setStyle("-fx-background-color: white;" + "-fx-text-fill: black;");
            t.clear();
        }

        updateScores();


    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }
}
