package model;

import java.util.Arrays;
import java.util.Random;

public class Yatzy {
    // Face values of the 5 dice.
    // 1 <= values[i] <= 6.
    private int[] values = new int[5];

    // Number of times the 5 dice have been thrown.
    // 0 <= throwCount <= 3.
    private int throwCount = 0;

    //Array with number of each value rolled
    int[] counts = new int[7];

    // Random number generator.
    private Random random = new Random();

    public Yatzy() {
        //
    }

    /**
     * Returns the 5 face values of the dice.
     */
    public int[] getValues() {
        return values;
    }

    /**
     * Sets the 5 face values of the dice. Pre: values contains 5 face values in
     * [1..6]. Note: This method is only meant to be used for test, and
     * therefore has package visibility.
     */
    public void setValues(int[] values) {

        this.values = values;
        calcCounts();
    }

    /**
     * Returns the number of times the 5 dice has been thrown.
     */
    public int getThrowCount() {
        return throwCount;
    }

    /**
     * Resets the throw count.
     */
    public void resetThrowCount() {
        throwCount = 0;
    }

    /**
     * Rolls the 5 dice. Only roll dice that are not hold. Pre: holds contain 5
     * boolean values.
     */
    public void throwDice(boolean[] holds) {
        for (int i = 0; i < values.length; i++) {
            if (!holds[i]) {
                values[i] = random.nextInt(1, 7);
            }
        }
        throwCount++;
    }

    // -------------------------------------------------------------------------

    /**
     * Returns all results possible with the current face values. The order of
     * the results is the same as on the score board. Note: This is an optional
     * method. Comment this method out, if you don't want use it.
     */
    public int[] getResults() {
        int[] results = new int[15];
        for (int i = 0; i <= 5; i++) {
            results[i] = this.sameValuePoints(i + 1);
        }
        results[6] = this.onePairPoints();
        results[7] = this.twoPairPoints();
        results[8] = this.threeSamePoints();
        results[9] = this.fourSamePoints();
        results[10] = this.fullHousePoints();
        results[11] = this.smallStraightPoints();
        results[12] = this.largeStraightPoints();
        results[13] = this.chancePoints();
        results[14] = this.yatzyPoints();

        return results;
    }

    // -------------------------------------------------------------------------

    // Returns an int[7] containing the frequency of face values.
    // Frequency at index v is the number of dice with the face value v, 1 <= v
    // <= 6.
    // Index 0 is not used.
    public int[] calcCounts() {
        Arrays.fill(counts, 0);

        for (int value : values) {
            counts[value]++;
        }
        return counts;
    }

    /**
     * Returns same-value points for the given face value. Returns 0, if no dice
     * has the given face value. Pre: 1 <= value <= 6;
     */
    public int sameValuePoints(int value) {

        return counts[value] * value;
    }

    /**
     * Returns points for one pair (for the face value giving highest points).
     * Returns 0, if there aren't 2 dice with the same face value.
     */
    public int onePairPoints() {
        for (int i = counts.length - 1; i > 0; i--) {
            if (counts[i] >= 2) {
                return i * 2;
            }
        }
        return 0;
    }

    /**
     * Returns points for two pairs (for the 2 face values giving highest
     * points). Returns 0, if there aren't 2 dice with one face value and 2 dice
     * with a different face value.
     */
    public int twoPairPoints() {
        int pair1 = 0;
        for (int i = counts.length - 1; i > 0; i--) {
            if (counts[i] >= 2) {
                if (pair1 > 0) {
                    return i * 2 + pair1 * 2;
                } else {
                    pair1 = i;
                }
            }
        }
        return 0;
    }

    /**
     * Returns points for 3 of a kind. Returns 0, if there aren't 3 dice with
     * the same face value.
     */
    public int threeSamePoints() {
        for (int i = counts.length - 1; i > 0; i--) {
            if (counts[i] >= 3) {
                return i * 3;
            }
        }
        return 0;
    }

    /**
     * Returns points for 4 of a kind. Returns 0, if there aren't 4 dice with
     * the same face value.
     */
    public int fourSamePoints() {
        for (int i = counts.length - 1; i > 0; i--) {
            if (counts[i] >= 4) {
                return i * 4;
            }
        }
        return 0;
    }

    /**
     * Returns points for full house. Returns 0, if there aren't 3 dice with one
     * face value and 2 dice a different face value.
     */
    public int fullHousePoints() {
        int pair1 = 0;
        int triple1 = 0;
        for (int i = counts.length - 1; i > 0; i--) {
            if (counts[i] == 3) {
                triple1 = i;
            } else if (counts[i] == 2) {
                pair1 = i;
            }

        }
        return pair1 * 2 + triple1 * 3;
    }

    /**
     * Returns points for small straight. Returns 0, if the dice are not showing
     * 1,2,3,4,5.
     */
    public int smallStraightPoints() {
        for (int i = 1; i < counts.length - 1; i++) {
            if (counts[i] != 1) {
                return 0;
            }
        }
        return 15;
    }

    /**
     * Returns points for large straight. Returns 0, if the dice is not showing
     * 2,3,4,5,6.
     */
    public int largeStraightPoints() {
        for (int i = 2; i < counts.length; i++) {
            if (counts[i] != 1) {
                return 0;
            }
        }
        return 20;
    }

    /**
     * Returns points for chance.
     */
    public int chancePoints() {
        int points = 0;
        for (int v : values) {
            points += v;
        }
        return points;
    }

    /**
     * Returns points for yatzy. Returns 0, if there aren't 5 dice with the same
     * face value.
     */
    public int yatzyPoints() {
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] == 5) {
                return 50;
            }
        }
        return 0;
    }

}
