package Application.Model;

import java.util.ArrayList;

public class Plads {
    //Fields
    private int nr;
    private Område område;

    public static double standardTimePris = 50;

    private ArrayList<Reservation> reservationer = new ArrayList<>();

    //Constructor
    public Plads (int nr, Område område) {
        this.nr = nr;
        this.område = område;
    }

    //Methods

    public int getNr() {
        return nr;
    }

    public Område getOmråde() {
        return område;
    }

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public void addReservation (Reservation reservation) {
        if (!reservationer.contains(reservation)) {
            reservationer.add(reservation);
            reservation.addPlads(this);
        }
    }

    public void removeReservation (Reservation reservation) {
        if (reservationer.contains(reservation)) {
            reservationer.remove(reservation);
            reservation.removePlads(this);
        }
    }

    public static double getStandardTimePris() {
        return standardTimePris;
    }

    public static void setStandardTimePris(double standardTimePris) {
        Plads.standardTimePris = standardTimePris;
    }

    public double pris (int timer) {
        double multiplier = 1.0;
        if (område == Område.TURNERING) {
            multiplier = 1.1;
        }else if (område == Område.VIP) {
            multiplier = 1.25;
        }else if (område == Område.BØRNE) {
            multiplier = 0.8;
        } else {
            multiplier = 1.0;
        }
        return timer * standardTimePris * multiplier;
    }

    @Override
    public String toString() {
        return "Plads "+nr+", "+område;
    }
}
