package Storage;

import Application.Model.Funktion;
import Application.Model.Medarbejder;
import Application.Model.Vagt;

import java.util.ArrayList;

public class Storage {

    //Lists    ________________________________________________________________________________________
    private static ArrayList<Medarbejder>medarbejdere = new ArrayList<>();
    private static ArrayList<Funktion> funktioner = new ArrayList<>();
    private static ArrayList<Vagt> vagter = new ArrayList<>();

    //Methods   -   Get    ________________________________________________________________________________________
    public static ArrayList<Medarbejder> getMedarbejdere() {
        return new ArrayList<>(medarbejdere);
    }

    public static ArrayList<Funktion> getFunktioner() {
        return new ArrayList<>(funktioner);
    }

    public static ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    //Methods   -   Add    ________________________________________________________________________________________
    public static void addMedarbejder (Medarbejder medarbejder) {
        if (!medarbejdere.contains(medarbejder)) {
            medarbejdere.add(medarbejder);
        }
    }

    public static void addFunktion (Funktion funktion) {
        if (!funktioner.contains(funktion)) {
            funktioner.add(funktion);
        }
    }

    public static void addVagt (Vagt vagt) {
        if (!vagter.contains(vagt)) {
            vagter.add(vagt);
        }
    }
}
