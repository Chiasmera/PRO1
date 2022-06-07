package Opgave4;

import java.util.ArrayList;

/**
 * Models a training plan for a Swimmer
 */
public class TrainingPlan {
    private char level;
    private int weeklyWaterHours;
    private int weeklyStrengthHours;
    private ArrayList<Swimmer> swimmers = new ArrayList<>();

    public TrainingPlan(char level, int weeklyWaterHours, int weeklyStrengthHours) {
        this.level = level;
        this.weeklyWaterHours = weeklyWaterHours;
        this.weeklyStrengthHours = weeklyStrengthHours;
    }

    public char getLevel() {
        return level;
    }

    public void setLevel(char niveau) {
        this.level = niveau;
    }

    public int getWeeklyStrengthHours() {
        return weeklyStrengthHours;
    }

    public void setWeeklyStrengthHours(int weeklyStrengthHours) {
        this.weeklyStrengthHours = weeklyStrengthHours;
    }

    public int getWeeklyWaterHours() {
        return weeklyWaterHours;
    }

    public void setWeeklyWaterHours(int weeklyWaterHours) {
        this.weeklyWaterHours = weeklyWaterHours;
    }

    /**
     * Returns a copy of the list of swimmers with this plan
     *
     * @return ArrayList of swimmers with this plan
     */
    public ArrayList<Swimmer> getSwimmers() {
        return new ArrayList<>(swimmers);
    }

    /**
     * Creates a new swimmer and adds it to the list of swimmers with this plan
     * @param name name of the swimmer
     * @param yearGroup yeargroup of the swimmer
     * @param club club of the swimmer
     * @param lapTimes list of laptimes of the swimmer
     */
    public Swimmer createSwimmer(String name, int yearGroup, String club, ArrayList<Double> lapTimes) {
        Swimmer s1 = new Swimmer(name, yearGroup, lapTimes, club);
        swimmers.add(s1);
        return s1;
    }

    /**
     * Removes the swimmer from the trainingplans list of swimmer, if it is present in the list
     * @param swimmer the swimmer to remove
     */
    public void removeSwimmer (Swimmer swimmer) {
        if (swimmers.contains(swimmer)) {
            swimmers.remove(swimmer);
        }
    }
}
