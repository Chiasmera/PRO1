package Opgave5;

import java.util.ArrayList;

public class Indkøbsvogn {
    //Fields
    private ArrayList<Vare> varer = new ArrayList<>();

    //constructor
    public Indkøbsvogn () {

    }

    //Methods
    public void addVare (int count, Vare vare) {
        for (int i = 0; i <count; i++) {
            varer.add(vare);
        }
    }

    public void removeVare (Vare vare) {
        if (varer.contains(vare)) {
            varer.remove(vare);
        }
    }

    public double beregnSamletPris () {
        double sum = 0;
        for (Vare v : varer) {
            sum += v.beregnSalgspris();
        }
        return sum;
    }
}
