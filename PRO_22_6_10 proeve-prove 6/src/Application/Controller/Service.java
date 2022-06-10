package Application.Controller;

import Application.Model.Bane;
import Application.Model.Medlem;
import Application.Model.Reservation;
import Storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Service {

    public static Bane createBane(int nummer, String baneInfo) {
        Bane b1 = new Bane(nummer, baneInfo);
        Storage.addBane(b1);
        return b1;
    }

    public static Medlem createMedlem(String navn, String mobil, String mail) {
        Medlem m1 = new Medlem(navn, mobil, mail);
        Storage.addMedlem(m1);
        return m1;
    }

    public static Reservation createReservation (Medlem booker, Medlem makker, Bane bane, LocalDate dato, LocalTime startTid) {
        Reservation r1 = null;
        if (bane.isLedig(dato,startTid) && !booker.hasAktivReservation() && !makker.hasAktivReservation()) {
            r1 = booker.createReservation(dato,startTid,bane,makker);
        }
        return r1;
    }

    public static void writeLedigeTider (LocalDate dato, String filnavn) {
        File file = new File(filnavn);

        try (PrintWriter out = new PrintWriter(file)) {
            for (Bane b : Storage.getBaner()) {
                out.println("Bane: " + b.getNummer()+ " ("+b.getBaneInfo()+") "  + " er d. " + dato + "ledig klokken:");
                for (LocalTime t : b.getLedigeTiderPaaDag(dato)) {
                    out.println("\t"+t);
                }
                out.println();
            }

        } catch (FileNotFoundException fileNotFoundException) {
            throw new RuntimeException("File has not been found at the specified path. Please check the path and try again.");
        }
    }

    public static ArrayList<Bane> getBaner () {
        return Storage.getBaner();
    }

    public static void initStorage() {
        Medlem m1 = createMedlem("Lene Mikkelsen", "12345678","lm@msn.com");
        Medlem m2 = createMedlem("Finn Jensen", "22331144","fj@msn.com");

        Bane b1 = createBane(1,"Nord/Syd vendt");
        Bane b2 = createBane(2,"Under Egetræet");
        Bane b3 = createBane(3,"Med Tilskuerpladser");

    }
}
