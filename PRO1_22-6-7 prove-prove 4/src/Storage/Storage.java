package Storage;

import Application.Model.Arrangement;
import Application.Model.Tutor;
import Application.Model.Uddannelse;

import java.util.ArrayList;

public class Storage {

    public static ArrayList<Uddannelse> uddannelser = new ArrayList<>();
    public static ArrayList<Tutor> tutorer = new ArrayList<>();
    public static ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public static ArrayList<Uddannelse> getUddannelser() {
        return new ArrayList<>( uddannelser);
    }

    public static void addUddannelse (Uddannelse uddannelse) {
        if (!uddannelser.contains(uddannelse)) {
            uddannelser.add(uddannelse);
        }
    }

    public static ArrayList<Tutor> getTutorer() {
        return new ArrayList<>( tutorer);
    }

    public static void addTutor (Tutor tutor) {
        if (!tutorer.contains(tutor)) {
            tutorer.add(tutor);
        }
    }

    public static ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

    public static void addArrangement (Arrangement arrangement) {
        if (!arrangementer.contains(arrangement)) {
            arrangementer.add(arrangement);
        }
    }
}
