package Application.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation implements Comparable<Reservation>{

    private LocalDate dato;
    private LocalTime startTid;
    private Bane bane;
    private Medlem booker;
    private Medlem makker;


    Reservation (LocalDate dato, LocalTime startTid, Bane bane, Medlem booker, Medlem makker) {
        this.dato = dato;
        this.startTid = startTid;
        this.bane = bane;
        bane.addReservation(this);
        this.booker = booker;
        this.makker = makker;
        makker.addReservation(this);
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public Bane getBane() {
        return bane;
    }

    public Medlem getBooker() {
        return booker;
    }

    public Medlem getMakker() {
        return makker;
    }

    @Override
    public int compareTo(Reservation o) {
        int orden = this.dato.compareTo(o.dato);
        if (orden == 0) {
            orden = this.startTid.compareTo(o.startTid);
        }
        if (orden == 0) {
            orden = o.getBane().getNummer() - this.getBane().getNummer();
        }
        return orden;
    }
}
