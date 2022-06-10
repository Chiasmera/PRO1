package Storage;

import Application.Model.Bane;
import Application.Model.Medlem;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Medlem> medlemmer = new ArrayList<>();
    private static ArrayList<Bane> baner = new ArrayList<>();

    public static ArrayList<Bane> getBaner() {
        return new ArrayList<>( baner);
    }

    public static ArrayList<Medlem> getMedlemmer () {
        return new ArrayList<>(medlemmer);
    }

    public static void addMedlem (Medlem medlem) {
        if (!medlemmer.contains(medlem)) {
            medlemmer.add(medlem);
        }
    }

    public static void addBane (Bane bane) {
        if (!baner.contains(bane)) {
            baner.add(bane);
        }
    }
}
