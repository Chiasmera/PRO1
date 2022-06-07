package Application.Model;

import java.util.ArrayList;

public class Arrangement {
    //Fields
    private String navn;
    private boolean offentlig;

    private ArrayList<Reservation> reservationer = new ArrayList<>();

    //Constructor
    public Arrangement(String navn, boolean offentlig) {
        this.navn = navn;
        this.offentlig = offentlig;
    }

    //Methods

    public String getNavn() {
        return navn;
    }

    public boolean isOffentlig() {
        return offentlig;
    }

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

    public void addReservation (Reservation reservation) {
        if (!reservationer.contains(reservation)) {
            reservationer.add(reservation);
        }
    }

    public void removeReservation (Reservation reservation) {
        if (reservationer.contains(reservation)) {
            reservationer.remove(reservation);
        }
    }

    /**
     * Returnerer summen af alle pladser i alle reservationer
     * @return sum af alle reserverede pladser
     */
    public int antalReserveredePladser () {
        int sum = 0;
        for (Reservation r : reservationer) {
            sum += r.getPladser().size();
        }
        return sum;
    }
}
