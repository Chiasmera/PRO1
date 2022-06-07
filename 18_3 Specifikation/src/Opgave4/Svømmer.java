package Opgave4;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Modellerer en svømmer
 */
public class Svømmer {
    private String navn;
    private String klub;
    private LocalDate fødselsdag;
    private ArrayList<Double> tider;

    /**
     * Initialiserer en ny svømmer med navn, fødselsdag, klub
     * og tider.
     * Pre: længden af tider er mindst 2
     */
    public Svømmer(String navn, LocalDate fødselsdag, String klub, ArrayList<Double> tider) {
        this.navn = navn;
        this.fødselsdag = fødselsdag;
        this.klub = klub;
        this.tider = tider;
    }

    /**
     * Returnerer svømmerens navn.
     */
    public String getNavn() {
        return navn;
    }

    /**
     * Returnerer svømmerens årgang.
     */
    public int getÅrgang() {
        int årgang = fødselsdag.getYear();
        return årgang;
    }

    /**
     * Returnerer svømmerens klub.
     */
    public String getKlub() {
        return klub;
    }

    /*** Registrerer svømmerens klub
     * @param klub svømmerens klub
     */
    public void setKlub(String klub) {
        this.klub = klub;
    }

    /**
     * Returnerer den hurtigste tid svømmeren har opnået
     * Pre: Der er registreret mindst to tider for svømmeren
     */
    public double bedsteTid() {
        double bedsteTid = tider.get(0);
        for (int i = 1; i < tider.size(); i++) {
            if (tider.get(i) < bedsteTid) {
                bedsteTid = tider.get(i);
            }
        }
        return bedsteTid;
    }

    /**
     * Returnerer gennemsnittet af de tider svømmeren har
     * opnået
     * Pre: Der er registreret mindst to tider for svømmeren
     */
    public double gennemsnitAfTid() {
        double sum = 0;
        for (double t : tider) {
            sum += t;
        }
        return sum / tider.size();
    }

    /**
     * Returnerer gennemsnittet af de tider svømmeren har
     * opnået idet den langsomste tid ikke er medregnet
     * Pre: Der er registreret mindst to tider for svømmeren
     */
    public double snitUdenDårligste() {
        double sum = tider.get(0);
        double værste = tider.get(0);
        for (int i = 1; i < tider.size(); i++) {
            sum += tider.get(i);
            if (tider.get(i) > værste) {
                værste = tider.get(i);
            }
        }
        return (sum -= værste) / (tider.size() - 1);
    }
}