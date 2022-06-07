package Storage;

import Application.Model.Arrangement;
import Application.Model.Plads;
import Application.Model.Reservation;

import java.util.ArrayList;

public class Storage {

    //Lists
    private static ArrayList<Arrangement> arrangementer = new ArrayList<>();
    private static ArrayList<Plads> pladser = new ArrayList<>();
    private static ArrayList<Reservation> reservationer = new ArrayList<>();

    //Methods
    public static ArrayList<Arrangement> getArrangementer () {
        return new ArrayList<>(arrangementer);
    }

    public static ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public static ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public static void addPlads (Plads plads) {
        pladser.add(plads);
    }

    public static void addReservation (Reservation reservation) {
        reservationer.add(reservation);
    }

    public static void addArrangement (Arrangement arrangement) {
        arrangementer.add(arrangement);
    }
}
