package Opgave5;

import java.util.ArrayList;

public class Series {
    //fields
    String title;
    ArrayList<String> cast = new ArrayList<>();
    ArrayList<Episode> episodes = new ArrayList<>();

    //constructor
    public Series (String title, ArrayList<String> cast) {
        this.title = title;
        this.cast = cast;
    }

    //Methods

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    /**
     * Creates a new episode and adds it to the list of episodes
     * @param number the number of the episode
     * @param guestActors a list of guest actors in the episode
     * @param lenghtMinutes the lenght of the episode in minutes
     * @return the new episode
     */
    public Episode createEpisode (int number, ArrayList<String> guestActors, int lenghtMinutes) {
        Episode e1 = new Episode(number, guestActors, lenghtMinutes, this);
        return e1;
    }

    /**
     * Removes the episode from the list of episodes
     * @param episode the episode to remove
     */
    public void removeEpisode (Episode episode) {
        if (episodes.contains(episode)) {
            episodes.remove(episode);
        }
    }

    /**
     * Returns a copy of the list of episodes
     * @return a copy of the list of episodes
     */
    public ArrayList<Episode> getEpisodes() {
        return new ArrayList<>(episodes);
    }

    /**
     * Return the total length (in minutes) of all the
     * episodes in the series.
     * @return the total length of all episodes in the series, in minutes
     */
    public int totalLength() {
        int totalMinutes = 0;
        for (Episode e : episodes) {
            totalMinutes += e.getLenght();
        }
        return totalMinutes;
    }

    /**
     * Return the total list of all guest actors from all
     * episodes.
     */
    public ArrayList<String> getGuestActors() {
        ArrayList<String> allGuestActors = new ArrayList<>();
        for (Episode e : episodes) {
            allGuestActors.addAll(e.getGuestActors());
        }
        return allGuestActors;
    }

}
