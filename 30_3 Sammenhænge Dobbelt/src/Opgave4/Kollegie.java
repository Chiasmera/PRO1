package Opgave4;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Kollegie {
    //Fields
    private String navn;
    private String adresse;

    private ArrayList<Bolig> boliger = new ArrayList<>();

    //Constructor
    public Kollegie (String navn, String adresse) {
        this.navn = navn;
        this.adresse = adresse;
    }

    //Methods

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void addBolig (Bolig bolig) {
        if (!boliger.contains(bolig)) {
            boliger.add(bolig);
        }
    }

    public void removeBolig (Bolig bolig) {
        if (boliger.contains(bolig)) {
            boliger.remove(bolig);
        }
    }

    public ArrayList<Bolig> getBoliger() {
        return new ArrayList<>(boliger);
    }

    public int getAntalLejeaftaler () {
        int sum = 0;
        for (Bolig b : boliger) {
            sum += b.getLejeaftaler().size();
        }
        return sum;
    }

    public double gennemsnitligAntalDage () {
        double sum = 0;
        int number = 0;
        for (Bolig b : boliger) {
            for (Lejeaftale l : b.getLejeaftaler()) {
                if (l.getTilDato() != null) {
                    sum += l.getFraDato().until(l.getTilDato(), ChronoUnit.DAYS);
                    number++;
                }
            }
        }
        return sum / number;
    }
}
