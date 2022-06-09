package Storage;

import Application.Model.Kamp;
import Application.Model.Spiller;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Kamp> kampe = new ArrayList<>();
    private static ArrayList<Spiller> spillere = new ArrayList<Spiller>();

    public static ArrayList<Kamp> getKampe() {
        return new ArrayList<>(kampe);
    }

    public static ArrayList<Spiller> getSpillere() {
        return new ArrayList<>(spillere);
    }

    public static void addKamp (Kamp kamp) {
        if (!kampe.contains(kamp)) {
            kampe.add(kamp);
        }
    }

    public static void addSpiller (Spiller spiller) {
        if (!spillere.contains(spiller)) {
            spillere.add(spiller);
        }
    }

    public static void removeSpiller (Spiller spiller) {
        if (spillere.contains(spiller)) {
            spillere.remove(spiller);
        }
    }

    public static void removeKamp ( Kamp kamp) {
        if (kampe.contains(kamp)) {
            kampe.remove(kamp);
        }
    }
}
