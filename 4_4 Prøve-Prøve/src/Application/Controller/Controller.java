package Application.Controller;

import Application.Model.Arrangement;
import Application.Model.Område;
import Application.Model.Plads;
import Application.Model.Reservation;
import Storage.Storage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {

    public static Arrangement createArrangement (String navn, boolean offentlig) {
        Arrangement a = new Arrangement(navn, offentlig);
        Storage.addArrangement(a);
        return a;
    }

    public static void addReservationTilArrangement (Reservation reservation, Arrangement arrangement) {
        if (!arrangement.getReservationer().contains(reservation)) {
            arrangement.addReservation(reservation);
        }
    }

    public static Reservation createReservation (LocalDateTime start, LocalDateTime slut) {
        Reservation r = new Reservation(start, slut);
        Storage.addReservation(r);
        return r;
    }

    public static void addPladsTilReservation (Plads plads, Reservation reservation) {
        if (!reservation.getPladser().contains(plads)) {
            reservation.addPlads(plads);
        }
    }

    public static Plads createPlads (int nr, Område område) {
        Plads p = new Plads(nr, område);
        Storage.addPlads(p);
        return p;
    }

    public static ArrayList<Plads> getPladser () {
        return Storage.getPladser();
    }

    //------------------------------------------------------------

    public static void initStorage () {
        Plads p1 = createPlads(1, Område.TURNERING);
        Plads p2 =createPlads(2,Område.TURNERING);
        Plads p3 =createPlads(3,Område.STANDARD);
        Plads p4 =createPlads(4,Område.STANDARD);
        Plads p5 =createPlads(5,Område.BØRNE);
        Plads p6 =createPlads(6,Område.VIP);

        Arrangement a1 = createArrangement("Dota 2 tournament", true);
        Arrangement a2 = createArrangement("CS GO tournament", false);

        Reservation r1 = createReservation(LocalDateTime.of(2019,8,12,20,0),LocalDateTime.of(2019,8,12,23,0));
        addPladsTilReservation(p1, r1);
        addPladsTilReservation(p2, r1);
        addReservationTilArrangement(r1,a1);

        Reservation r2 = createReservation(LocalDateTime.of(2019,8,13,19,0),LocalDateTime.of(2019,8,14,06,0));
        addPladsTilReservation(p3, r2);
        addPladsTilReservation(p4, r2);

        Reservation r3 = createReservation(LocalDateTime.of(2019,8,14,19,0),LocalDateTime.of(2019,8,15,06,0));
        addPladsTilReservation(p6, r3);
    }
}
