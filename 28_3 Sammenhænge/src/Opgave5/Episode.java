package Opgave5;

import java.util.ArrayList;

public class Episode {
    //Fields
    int number;
    ArrayList<String> guestActors = new ArrayList<>();
    int lenghtMinutes;

    //constructor
    public Episode (int number, ArrayList<String> guestActors, int lenghtMinutes, Series series) {
        this.number = number;
        this.guestActors = guestActors;
        this.lenghtMinutes = lenghtMinutes;
        series.episodes.add(this);
    }


    //Methods

    public int getNumber() {
        return number;
    }

    public int getLenght() {
        return lenghtMinutes;
    }

    public ArrayList<String> getGuestActors() {
        return guestActors;
    }
}
