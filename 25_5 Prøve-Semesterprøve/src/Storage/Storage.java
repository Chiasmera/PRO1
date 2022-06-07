package Storage;

import App.Model.Bil;
import App.Model.Parkeringshus;

import java.util.ArrayList;

public class Storage {

    //Lister
    private static ArrayList<Parkeringshus> parkeringshuse = new ArrayList<>();
    private static ArrayList<Bil> biler = new ArrayList<>();

    //Get Methods

    public static ArrayList<Bil> getBiler() {
        return new ArrayList<>(biler);
    }

    public static ArrayList<Parkeringshus> getParkeringshuse() {
        return new ArrayList<>(parkeringshuse);
    }

    //Add Methods
    public static void addBil (Bil bil) {
        if (!biler.contains(bil)) {
            biler.add(bil);
        }
    }

    public static void addParkeringshus (Parkeringshus parkeringshus) {
        if (!parkeringshuse.contains(parkeringshus)) {
            parkeringshuse.add(parkeringshus);
        }
    }


}
