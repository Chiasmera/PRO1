package Application.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {

    private int nummer;
    private String baneInfo;
    private ArrayList<Reservation> reservationer = new ArrayList<>();

    public Bane (int nummer, String baneInfo) {
        this.nummer = nummer;
        this.baneInfo = baneInfo;
    }

    public int getNummer() {
        return nummer;
    }

    public String getBaneInfo() {
        return baneInfo;
    }

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>(reservationer);
    }

/*    public void addReservation (Reservation reservation) {
        if (!reservationer.contains(reservation)) {
            reservationer.add(reservation);
        }
    }*/

    public void addReservation (Reservation reservation) {
        if (reservationer.size() == 0) {
            reservationer.add(reservation);
        } else {
            int i = reservationer.size()-1;
            while (reservationer.get(i).compareTo(reservation) > 0) {
                i--;
            }
            reservationer.add(i+1, reservation);
        }
    }


    public boolean isLedig (LocalDate dato, LocalTime tid) {
        boolean ledig = true;
        int i = 0;
        while (i < reservationer.size() && ledig) {
            if (reservationer.get(i).getDato().compareTo(dato) == 0 && tid.getHour() == reservationer.get(i).getStartTid().getHour()) {
                ledig = false;
            }
            i++;
        }
        return ledig;
    }

    public ArrayList<LocalTime> getLedigeTiderPaaDag (LocalDate dato) {
        ArrayList<LocalTime> ledigeTider = new ArrayList<>();
        for (int i = 6; i < 22; i++) {
            ledigeTider.add(LocalTime.of(i,0));


        }
        return ledigeTider;
    }

    @Override
    public String toString() {
        return nummer + " (" +baneInfo+")";
    }
}
